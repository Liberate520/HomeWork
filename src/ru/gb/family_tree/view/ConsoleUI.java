package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu mainMenu;
    private SortMenu sortMenu;
    private FamConnectMenu famConnectMenu;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        mainMenu = new MainMenu(this);
        sortMenu = new SortMenu(this);
        famConnectMenu = new FamConnectMenu(this);
    }

    @Override
    public void start() {
        System.out.println("===================================================");
        System.out.println("Приветствую. Это программа работы с семейным древом");
        System.out.println("===================================================");
       // while (work){


            showMainMenu();


       // }

    }

    private void showMainMenu() {
        while (work) {
            System.out.println(mainMenu.showMainMenu());
            String choiceStr = scanner.nextLine();
            if (isInt(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                if (choice > 0 && choice <= mainMenu.getSize()) {
                    mainMenu.execute(choice);
                } else {
                    System.out.println("Введена неверная команда 1");
                }
            } else {
                System.out.println("Введена неверная команда 2");
            }
        }
    }

    private static boolean isInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("До новых встреч!");
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByFirstName() {
        presenter.sortByFirstName();
    }

    public void getFamilyTreeInfo() {

        presenter.getFamilyTreeInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя");
        String firstName = scanner.nextLine();
        System.out.println("Укажите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Укажите дату рождения в формате yyyy-MM-dd");
        LocalDate dateOfBirth  = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println("Укажите пол мужской или женский");
        String genderStr = scanner.nextLine();
        Gender gender=null;
        if (genderStr.equals("мужской")) gender = Gender.мужской;
        else if (genderStr.equals("женский")) gender = Gender.женский;

        presenter.getFamilyTreeInfo();
        System.out.println("Введите id отца: ");
        int idDad = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id матери: ");
        int idMom = Integer.parseInt(scanner.nextLine());
        presenter.addHuman(firstName, lastName, dateOfBirth, gender, idMom, idDad);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println("Результат работы: \n" + answer);

    }

    public void sortMenuShow() {
        while (work) {
            System.out.println(sortMenu.showSortMenu());
            String choiceStr = scanner.nextLine();
            if (isInt(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                if (choice > 0 && choice <= mainMenu.getSize()) {
                    sortMenu.execute(choice);
                } else {
                    System.out.println("Введена неверная команда");
                }
            } else {
                System.out.println("Введена неверная команда");
            }
        }

    }

    public void backToMainMenu() {
        showMainMenu();
    }

    public void FamConnectMenuShow() {
        while (work) {
            System.out.println(famConnectMenu.showFamConnectMenu());
            String choiceStr = scanner.nextLine();
            if (isInt(choiceStr)) {
                int choice = Integer.parseInt(choiceStr);
                if (choice > 0 && choice <= mainMenu.getSize()) {
                    famConnectMenu.execute(choice);
                } else {
                    System.out.println("Введена неверная команда");
                }
            } else {
                System.out.println("Введена неверная команда");
            }
        }
    }

    public void addChild() {
    }

    public void addParents() {
    }

    public void addWedding() {
        presenter.getFamilyTreeInfo();
        System.out.println("Введите id супруга: ");
        int idPartner1 = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите id супруги: ");
        int idPartner2 = Integer.parseInt(scanner.nextLine());
        presenter.setWedding(idPartner1, idPartner2);

    }
}
