package family_tree.presenter;

import family_tree.model.human.Person;
import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import family_tree.view.View;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void addHuman (String name, LocalDate dob, Gender gender) {
        service.addHuman(name, dob, gender);
        getHumanListInfo();
    }

    public void setParents(int childId, Integer fatherId, Integer motherId) {
        service.setParents(childId, fatherId, motherId);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String answer = service.getHumanListInfo();
        view.printAnswer(answer);
    }

    public void sortByName () {
        service.sortByName();
        getHumanListInfo();
    }

    public void sortByDateBirth () {
        service.sortByDateBirth();
        getHumanListInfo();
    }

    public Person findHumanById(int id) {
        return service.findHumanById(id);
    }

    public List<Person> findHumansByName(String name) {
        return service.findHumansByName(name);
    }

    public void finish() {
        service.finish();
    }
}
