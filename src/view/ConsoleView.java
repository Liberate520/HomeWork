package view;

import model.Result;
import model.User;
import model.WOD;
import presenter.Presenter;

import java.util.Scanner;

public class ConsoleView implements View {
    private final Scanner scanner;
    private boolean work;
    private final Presenter presenter;
    private final MainMenu menu;

    public ConsoleView(Presenter presenter) {
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.presenter = presenter;
        this.menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствие");
        while (work) {
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            if (choice >= 1 && choice <= menu.size()) {
                menu.execute(choice);
            } else {
                printAnswer("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("До новых встреч");
    }

    public void registerUser() {
        System.out.println("Введите логин:");
        String login = scanner.nextLine();

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        System.out.println("Введите имя:");
        String firstName = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String lastName = scanner.nextLine();

        User user = new User(login, password, firstName, lastName);
        presenter.registerUser(user);
        printAnswer("Пользователь зарегистрирован.");
    }

    public void authenticateUser() {
        System.out.println("Введите логин:");
        String login = scanner.nextLine();

        System.out.println("Введите пароль:");
        String password = scanner.nextLine();

        User user = presenter.authenticateUser(login, password);
        if (user != null) {
            printAnswer("Аутентификация успешна. Добро пожаловать, " + user.getFirstName() + " " + user.getLastName());
        } else {
            printAnswer("Неверный логин или пароль.");
        }
    }

    public void addWOD() {
        System.out.println("Введите название WOD:");
        String title = scanner.nextLine();

        System.out.println("Введите описание WOD:");
        String description = scanner.nextLine();

        System.out.println("Введите метод оценки (Minimal Time или Max Reps):");
        String scoringMethod = scanner.nextLine();

        WOD wod = new WOD(title, description, scoringMethod);
        presenter.addWOD(wod);
        printAnswer("WOD добавлен.");
    }

    public void addResult() {
        System.out.println("Введите ID атлета:");
        String athleteId = scanner.nextLine();

        System.out.println("Введите ID WOD:");
        String wodId = scanner.nextLine();

        System.out.println("Введите количество повторений (если применимо):");
        int repetitions = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Введите время (в формате mm:ss, если применимо):");
        String time = scanner.nextLine();

        System.out.println("Введите метод оценки (Minimal Time или Max Reps):");
        String scoringMethod = scanner.nextLine();

        User athlete = presenter.getUserById(athleteId);
        WOD wod = presenter.getWODById(wodId);
        if (athlete != null && wod != null) {
            Result result = new Result(athlete, wod, repetitions, time, scoringMethod);
            presenter.addResult(result);
            printAnswer("Результат добавлен.");
        } else {
            printAnswer("Некорректный ID атлета или WOD.");
        }
    }

    public void viewAllWODs() {
        presenter.getAllWODs().forEach(wod -> {
            System.out.println("ID: " + wod.getId() + ", Название: " + wod.getTitle() + ", Описание: " + wod.getDescription());
        });
    }

    public void viewResultsByWOD() {
        System.out.println("Введите ID WOD:");
        String wodId = scanner.nextLine();
        WOD wod = presenter.getWODById(wodId);
        if (wod != null) {
            presenter.getResultsByWOD(wod).forEach(result -> {
                System.out.println("ID атлета: " + result.getAthlete().getId() + ", Повторения: " + result.getRepetitions() + ", Время: " + result.getTime());
            });
        } else {
            printAnswer("Некорректный ID WOD.");
        }
    }

    public void viewResultsByAthlete() {
        System.out.println("Введите ID атлета:");
        String athleteId = scanner.nextLine();
        User athlete = presenter.getUserById(athleteId);
        if (athlete != null) {
            presenter.getResultsByAthlete(athlete).forEach(result -> {
                System.out.println("ID WOD: " + result.getWod().getId() + ", Повторения: " + result.getRepetitions() + ", Время: " + result.getTime());
            });
        } else {
            printAnswer("Некорректный ID атлета.");
        }
    }

    public void viewSortedAthletes() {
        presenter.getSortedAthletes().forEach(athlete -> {
            System.out.println("ID: " + athlete.getId() + ", Имя: " + athlete.getFirstName() + " " + athlete.getLastName() + ", Итоговый балл: " + presenter.calculateTotalScore(athlete));
        });
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
