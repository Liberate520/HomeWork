package view;


import model.human.Gender;
import presenter.Presenter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View, Serializable {
    private static final long serialVersionUID = 1L;
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        presenter = new Presenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Программа \"Семейное дерево\"");
        while (work) {
            System.out.println(menu.menu());
            menu.execute(getCheckMenuSize());
        }
    }

    public void finish() {
        work = false;
        scanner.close();
        System.out.println("До свидания!");
    }

    public void setParentId(){
        System.out.println("Укажите ID ребенка");
        long childId = checkHumanId();
        System.out.println("Укажите ID родителя");
        long parentId = checkHumanId();
        presenter.setParentId(childId, parentId);
    }

    private long checkHumanId() {
        while (true) {
            String childIdStr = scanner.nextLine();
            long childId = Long.parseLong(childIdStr);
            if (childId >= 0 && childId < familyTreeSize()) {
                return childId;
            } else {
                System.out.println("Нет человека с таким ID");
                System.out.println("Повторите ввод");
            }
        }
    }


    private int familyTreeSize() {
        return presenter.familyTreeSize();
    }



    private int getCheckMenuSize() {
        while (true) {
            String choiceStr = scanner.nextLine();
            int choice = Integer.parseInt(choiceStr);
            if (choice > 0 && choice <= menu.menuSize() ) {
                return choice;
            } else {
                System.out.println("Выберите число, соответствующее пунктам меню");
                System.out.println(menu.menu());
            }
        }
    }

    public void saveTree() {
        presenter.saveTree();
        work = false;
        scanner.close();
        System.out.println("До новых встреч!");
    }

    public void readTree() {
        presenter.readTree();

    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        System.out.println("Укажите имя: ");
        String name = scanner.nextLine();
        LocalDate birthDate = getLocalDate();
        Gender gender = getGender();
        presenter.addHuman(name, birthDate, gender);
    }

    private Gender getGender() {
        while (true) {
            System.out.println("Укажите пол (м/ж): ");
            String genderStr = scanner.nextLine();
            if (genderStr.equals("м")) {
                return Gender.Male;
            } else if (genderStr.equals("ж")) {
                return Gender.Female;
            } else {
                System.out.println("Введите пол (м или ж)");
            }
        }
    }

    private LocalDate getLocalDate() {
        while (true) {
            System.out.println("Введите дату рождения (dd.MM.yyyy): ");
            String birthDateStr = scanner.nextLine();
            if (isValidDate(birthDateStr)) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                return LocalDate.parse(birthDateStr, formatter);
            } else {
                System.out.println("Введите дату в указанном формате");
            }
        }

    }

    public static boolean isValidDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            LocalDate.parse(dateStr, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }


    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
