package presenter;

import model.Result;
import model.User;
import model.WOD;
import service.IResultService;
import service.IUserService;
import service.IWODService;

import java.util.List;

public class Presenter {

        private final IUserService userService;
        private final IWODService wodService;
        private final IResultService resultService;

        public Presenter(IUserService userService, IWODService wodService, IResultService resultService) {
            this.userService = userService;
            this.wodService = wodService;
            this.resultService = resultService;
        }

        public void registerUser(User user) {
            userService.registerUser(user);
        }

        public User authenticateUser(String login, String password) {
            String passwordHash = Integer.toString(password.hashCode());
            return userService.authenticateUser(login, passwordHash);
        }

        public void addWOD(WOD wod) {
            wodService.addWOD(wod);
        }

        public void addResult(Result result) {
            resultService.addResult(result);
        }

        public List<WOD> getAllWODs() {
            return wodService.getAllWODs();
        }

        public List<Result> getResultsByWOD(WOD wod) {
            return resultService.getResultsByWOD(wod);
        }

        public List<Result> getResultsByAthlete(User athlete) {
            return resultService.getResultsByAthlete(athlete);
        }

        public List<User> getSortedAthletes() {
            List<User> athletes = userService.getAllUsers();
            athletes.sort((a, b) -> Integer.compare(calculateTotalScore(b), calculateTotalScore(a)));
            return athletes;
        }

        public User getUserById(String id) {
            return userService.getUserById(id);
        }

        public WOD getWODById(String id) {
            return wodService.getWODById(id);
        }

        public int calculateTotalScore(User user) {
            return resultService.calculateTotalScore(user);
        }
    }


