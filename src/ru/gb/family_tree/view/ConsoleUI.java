package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void addHuman() {
        try {
            System.out.println("Введите имя человека:");
            String name = scanner.nextLine();
            System.out.println("Укажите дату рождения человека (гггг-мм-дд):");
            String dateOfBirthStr = scanner.nextLine();
            LocalDate dateOfBirth = LocalDate.parse(dateOfBirthStr);
            System.out.println("Укажите пол человека (Male/Female):");
            String genderStr = scanner.nextLine();
            //Gender gender = Gender.valueOf(genderStr.toUpperCase());
            Gender gender = Gender.valueOf(genderStr);
            System.out.println("Укажите имя отца человека (или оставьте пустым):");
            String father = scanner.nextLine();
            System.out.println("Укажите имя матери человека (или оставьте пустым):");
            String mother = scanner.nextLine();

            presenter.addHuman(name, dateOfBirth, gender, father, mother);
        } catch (Exception e) {
            System.out.println(INPUT_ERROR);
        }
    }

    private void hello() {
        System.out.println("Доброго времени суток!");
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    public void finish() {
        work = false;
        System.out.println("Работа завершена.");
    }
}
