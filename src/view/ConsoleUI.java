package view;

import model.human.Gender;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        loadTree();
        getFamilyTreeInfo();
        System.out.println("\nДобрый день! Выберите действие:\n");
        while (work) {
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        }
    }

    public void loadTree() {
        presenter.loadTree();
    }

    public void saveTree() {
        presenter.saveTree();
    }

    private void error() {
        System.out.println("Введено неверное значение");
    }

    public void finish() {
        saveTree();
        System.out.println("До новых встреч");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByID() {
        presenter.sortByID();
    }

    public void getFamilyTreeInfo() {
        presenter.getFamilyTreeInfo();
    }

    public int addHuman() {
        String name = questionName();
        LocalDate dateOfBirthday = questionDate();
        Gender gender = questionGender();
        System.out.println("\n");
        return presenter.addHuman(name, dateOfBirthday, gender);
    }

    public void addParent() {
        int child = findHuman();
        int parent = addHuman();
        presenter.addParent(child, parent);
    }

    public void addChildren() {
        int parent = findHuman();
        int child = addHuman();
        presenter.addChild(child, parent);
    }

    public String questionName() {
        System.out.println("Укажите имя человека");
        String name = scanner.nextLine();
        return name;
    }

    private LocalDate questionDate() {
        System.out.println("Укажите год рождения");
        String strYear = scanner.nextLine();
        int year = Integer.parseInt(strYear);

        System.out.println("Укажите месяц рождения");
        String strMonth = scanner.nextLine();
        int month = Integer.parseInt(strMonth);

        System.out.println("Укажите дату рождения");
        String strDate = scanner.nextLine();
        int date = Integer.parseInt(strDate);

        LocalDate localDate = LocalDate.of(year, month, date);
        return localDate;
    }

    public Gender questionGender() {
        System.out.println("Укажите пол Male/Female");
        String strGender = scanner.nextLine();
        Gender gender = Gender.valueOf(strGender);
        return gender;
    }

    public int findHuman() {
        boolean flag;
        getFamilyTreeInfo();
        System.out.println("Укажите id родственника");
        String strID = scanner.nextLine();
        int id = Integer.parseInt(strID);
        flag = availability(id);
        while (!flag) {
            System.out.println("id указан неверно");
            strID = scanner.nextLine();
            id = Integer.parseInt(strID);
            flag = availability(id);
        }
        return id;
    }

    public boolean availability(int id) {
        return presenter.availability(id);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
