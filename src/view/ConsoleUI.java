package view;

import model.human.Gender;
import presenter.Presenter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View, Serializable {
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
//        getFamilyTreeInfo();
        System.out.println("\nДобрый день! Выберите действие:\n");
        while (work) {
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
//            todo    метод проверки на валидность strChoice
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

    public void addHuman() {
        String name = questionName();
        LocalDate dateOfBirthday = questionDate();
        Gender gender = questionGender();

        presenter.addHuman(name, dateOfBirthday, gender);
        System.out.println("\n");
    }

    public void addParent() {
        String name = questionName();
        LocalDate dateOfBirthday = questionDate();
        Gender gender = questionGender();
        int id = questionnaireChoice();
        presenter.addParent(name, dateOfBirthday, gender, id);
        System.out.println("\n");
        //todo метод добавления родителя
    }

    public void addChildren() {
        String name = questionName();
        LocalDate dateOfBirthday = questionDate();
        Gender gender = questionGender();
        int id = questionnaireChoice();
        presenter.addChild(name, dateOfBirthday, gender, id);
        System.out.println("\n");
        //todo метод добавления ребенка
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

    public int questionnaireChoice() {
        getFamilyTreeInfo();
        System.out.println("Укажите id родственника");
        String strID = scanner.nextLine();
        int id = Integer.parseInt(strID);
        return id;
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


}
