package src.View;

import java.util.Scanner;

import src.Presenter.Presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;
    private DateParser dateParser;

    public ConsoleUI() throws SecurityException, IOException {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        dateParser = new DateParser();
    }

    @Override
    public void start() throws ClassNotFoundException, IOException {
        System.out.println("Здравствуйте!");
        while (work) {
            showMenu();
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            mainMenu.run(choice);
        }
    }

    public void stop() {
        work = false;
        scanner.close();
    }

    private void showMenu() {
        System.out.println(mainMenu.menu());
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения (год, месяц, день): ");
        LocalDate dateofbirth = dateParser.parseDate(scanner.nextLine());
        while (dateofbirth == null){
            System.out.println("Некорректный ввод, попробуйте еще раз.");
            System.out.println("Введите дату рождения (год, месяц, день): ");
            dateofbirth = dateParser.parseDate(scanner.nextLine());
        }
        System.out.println("Выберите пол \n 1 - Мужской \n 2 - Женский ");
        String gen = scanner.nextLine();
        String gender = null;
        switch (gen) {
            case "1":
                gender = "male";
                break;
            case "2":
                gender = "female";
                break;
            default:
                System.out.println("Неверный ввод");
        }
        presenter.addHuman(name, dateofbirth, gender);
        System.out.println("Добавлен новый член семьи");
    }

    public void getMember() {
        System.out.println("Введите имя ");
        String name = scanner.nextLine();
        presenter.getMember(name);
    }

    public void addParentOrChild() {
        System.out.println("Введите имя ребенка");
        String childName = scanner.nextLine();
        System.out.println("Введите имя родителя");
        String parentName = scanner.nextLine();
        presenter.addParentOrChild(childName, parentName);
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthday() {
        presenter.sortByBirthday();
    }

    public void sortByChildren() {
        presenter.sortByChildren();
    }

    public void load() throws ClassNotFoundException, IOException {
        presenter.load();
        System.out.println("Семейное древо усепшно загружено!");
    }

    public void save() throws FileNotFoundException, IOException {
        presenter.save();
        System.out.println("Семейное древо усепшно сoхранено!");
    }

    public void addInfo() {
        System.out.println("Введите имя члена семьи: ");
        String name = scanner.nextLine();
        if (presenter.findMember(name).getBirthDate() == null) {
            System.out.println("Желаете ввести дату рождения? \n 1 - Да  \n 2 - Нет");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Введите дату рождения (год, месяц, день): ");
                    LocalDate dateofbirth = dateParser.parseDate(scanner.nextLine());
                    while (dateofbirth == null){
                        System.out.println("Некорректный ввод, попробуйте еще раз.");
                        System.out.println("Введите дату рождения (год, месяц, день): ");
                        dateofbirth = dateParser.parseDate(scanner.nextLine());
                    }
                    presenter.findMember(name).setBirthDate(dateofbirth);
                case "2":
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
        if (presenter.findMember(name).getDeathDate() == null) {
            System.out.println("Желаете ввести дату смерти? \n 1 - Да  \n 2 - Нет");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Введите дату смерти (год, месяц, день): ");
                    LocalDate dateofdeath = dateParser.parseDate(scanner.nextLine());
                    while (dateofdeath == null){
                        System.out.println("Некорректный ввод, попробуйте еще раз.");
                        System.out.println("Введите дату смерти (год, месяц, день): ");
                        dateofdeath = dateParser.parseDate(scanner.nextLine());
                    }
                    presenter.findMember(name).setDeathDate(dateofdeath);
                case "2":
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
        if (presenter.findMember(name).getGender() == null) {
            System.out.println("Желаете ввести пол? \n 1 - Да  \n 2 - Нет");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Выберите пол \n 1 - Мужской \n 2 - Женский");
                    String gen = scanner.nextLine();
                    String gender = null;
                    switch (gen) {
                        case "1":
                            gender = "male";
                            presenter.findMember(name).setGender(presenter.setGender(gender));
                            break;
                        case "2":
                            gender = "female";
                            presenter.findMember(name).setGender(presenter.setGender(gender));
                            break;
                        default:
                            System.out.println("Неверный ввод");
                    }
                case "2":
                    break;
                default:
                    System.out.println("Неверный ввод");
            }
        }
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
