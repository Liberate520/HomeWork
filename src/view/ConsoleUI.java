package view;

import form.forming.Gender;
import presenter.Presenter;
import view.View;
import view.menu.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private List<Boolean> workMenu;
    private Menu startMenu;
    private String filePatch;


    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        workMenu = new ArrayList<>();
        startMenu = new StartMenu(this);
        filePatch = "src/Tree.txt";
    }

    @Override
    public void start() {
        System.out.println("Запуск программы");
        launchingMenu(startMenu);
    }

    private void launchingMenu(Menu menu) {
        workMenu.add(true);
        while (workMenu.getLast()) {
            System.out.println(menu.showMenu());
            int choice = chekingCoice(0, menu.getCommands().size() - 1);
            if (choice >= 0) {
                menu.execute(choice);
            }
        }
        workMenu.removeLast();
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }


    public void loadingTree() {
        presenter.loadingTree(filePatch);
    }


    public void savingTree() {
        presenter.savingTree(filePatch);
    }


    public void addHuman() {
        String name;
        Gender gender;
        String birthDate;
        String deathDate;

        name = enteringName();

        gender = enteringGender();

        System.out.println("Укажите дату рождения");
        birthDate = enteringDataStr(false);

        System.out.println("Укажите дату смерти (Введите пустую строку для пропуска)");
        deathDate = enteringDataStr(true);

        presenter.addHuman(name, gender, birthDate, deathDate);
    }


    public void findHuman() {
        String name;
        System.out.println("Введите ФИО или его часть: ");
        name = scanner.nextLine();
        if (presenter.findHuman(name)) {
            Menu actionFindMenu = new ActionFindMenu(this);
            launchingMenu(actionFindMenu);
        } else {
            System.out.println("Человек не найден");
        }
    }

    public void choicingSort() {
        Menu sortMenu = new SortMenu(this);
        launchingMenu(sortMenu);
    }


    public void choicingPrint() {
        Menu printMenu = new PrintMenu(this);
        launchingMenu(printMenu);
    }


    public void goOut() {
        workMenu.set(workMenu.size() - 1, false);
    }


    private boolean checkingIsDigital(String choiceStr) {
        return (choiceStr.matches("\\d+"));
    }


    private void printError(int min, int max) {
        System.out.printf("Вы ввели не коретные данные \nВведите число от %d до %d\n", min, max);
    }


    public void setParents() {
        int indexMother, indexFather;
        System.out.println("Выберите маму: \n");
        System.out.println(presenter.shortPrintTree());
        indexMother = chekingCoice(1, presenter.getSizeTree()) - 1;
        System.out.println("Выберите папу: \n");
        System.out.println(presenter.shortPrintTree());
        indexFather = chekingCoice(1, presenter.getSizeTree()) - 1;
        if (indexMother >= 0 && indexFather >= 0) {
            presenter.setParents(indexMother, indexFather);
        } else {
            System.out.println("Ошибка добавления родителей");
        }
    }


    public void getAge() {
        presenter.getAge();
    }


    public void getParents() {
        presenter.getParents();
    }


    public void getChildren() {
        presenter.getChildren();
    }


    public void getGrandparents() {
        presenter.getGrandparents();
    }


    public void getGrandsons() {
        presenter.getGrandsons();
    }


    public void sortName() {
        presenter.sortName();
        System.out.println("соритровка по имени");
        System.out.println(presenter.shortPrintTree());
    }


    public void sortAge() {
        presenter.sortAge();
        System.out.println("соритровка по возрасту");
        System.out.println(presenter.shortPrintTree());
    }


    public void sortNumberChildren() {
        presenter.sortNumberChildren();
        System.out.println("соритровка по количеству детей");
        System.out.println(presenter.shortPrintTree());
    }


    public void longPrint() {
        System.out.println(presenter.longPrintTree());
    }


    public void shortPrint() {
        System.out.println(presenter.shortPrintTree());
    }


    private int chekingCoice(int min, int max) {
        String choiceStr = scanner.nextLine();
        if (checkingIsDigital(choiceStr)) {
            int choice = Integer.parseInt(choiceStr);
            if (choice <= max && choice >= min) {
                return choice;
            } else {
                printError(min, max);
            }
        } else {
            printError(min, max);
        }
        return -1;
    }


    private String enteringName() {
        String name;
        boolean repeatQuestion;

        do {
            System.out.println("Введите ФИО: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                repeatQuestion = true;
                System.out.println("Вы ничего не ввели");
            } else {
                repeatQuestion = false;
            }
        } while (repeatQuestion);
        return name;
    }


    private Gender enteringGender() {
        String genderStr;
        System.out.println("Укажите пол: М или Ж");
        do {
            genderStr = scanner.nextLine().toLowerCase();
            switch (genderStr) {
                case ("м"):
                    return Gender.Male;
                case ("ж"):
                    return Gender.Female;
                default:
                    System.out.println("Укажите пол: М или Ж (Русская расладка)");
                    break;
            }
        } while (true);
    }


    private String enteringDataStr(boolean allowNull) {
        StringBuilder date = new StringBuilder();
        String temp;
        boolean repeatQuestion;

        System.out.println("Введите год");
        do {
            temp = scanner.nextLine();
            if (allowNull && temp.isEmpty()) {
                return null;
            }
            if (checkingIsDigital(temp) && Integer.parseInt(temp) > 1000 && Integer.parseInt(temp) < 2100) {
                date.append(temp);
                repeatQuestion = false;
            } else {
                System.out.println("укажите год от 1000 до 2100");
                repeatQuestion = true;
            }
        } while (repeatQuestion);

        System.out.println("Введите месяц");
        do {
            temp = scanner.nextLine();
            if (checkingIsDigital(temp) && Integer.parseInt(temp) < 13 && Integer.parseInt(temp) > 0) {
                date.append("-");
                if (Integer.parseInt(temp) < 10) {
                    date.append(0);
                }
                date.append(temp);
                repeatQuestion = false;
            } else {
                System.out.println("укажите месяц от 1 до 12");
                repeatQuestion = true;
            }
        } while (repeatQuestion);

        System.out.println("Введите число");
        do {
            temp = scanner.nextLine();
            if (checkingIsDigital(temp) && Integer.parseInt(temp) < 32 && Integer.parseInt(temp) > 0) {
                date.append("-");
                if (Integer.parseInt(temp) < 10) {
                    date.append(0);
                }
                date.append(temp);
                repeatQuestion = false;
            } else {
                System.out.println("укажите число от 1 до 31");
                repeatQuestion = true;
            }
        } while (repeatQuestion);
        return date.toString();
    }

}