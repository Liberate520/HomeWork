package ru.gb2.family_tree7.view;

import ru.gb2.family_tree7.model.human.Gender;
import ru.gb2.family_tree7.model.human.Human;
import ru.gb2.family_tree7.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
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
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        printAnswer("Добро пожаловать в систему семейного дерева!");
        while (work) {
            printAnswer("Выберите команду:");
            printAnswer(mainMenu.menu());

            // Обработчик выбора команды
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice < 1 || choice > mainMenu.getSize()) {
                    printAnswer("Некорректный выбор. Пожалуйста, попробуйте еще раз.");
                    continue;
                }
                mainMenu.execute(choice);
            } catch (NumberFormatException e) {
                printAnswer(INPUT_ERROR);
            }
        }
    }

    public void finish() {
        printAnswer("Приятно было пообщаться!");
        work = false;
    }

    public void addHuman() {
        printAnswer("Введите имя человека:");
        String name = scanner.nextLine();

        printAnswer("Укажите пол человека (MALE/FEMALE):");
        Gender gender = null;
        while (gender == null) {
            String genderString = scanner.nextLine();
            try {
                gender = Gender.valueOf(genderString.toUpperCase());
            } catch (IllegalArgumentException e) {
                printAnswer("Некорректный пол, используйте MALE или FEMALE.");
            }
        }

        printAnswer("Введите дату рождения (YYYY-MM-DD):");
        LocalDate birthDate;
        while (true) {
            try {
                birthDate = LocalDate.parse(scanner.nextLine());
                break;
            } catch (Exception e) {
                printAnswer("Некорректная дата. Пожалуйста, введите в формате YYYY-MM-DD.");
            }
        }

        printAnswer("Введите дату смерти (при наличии, YYYY-MM-DD), или оставьте пустым:");
        LocalDate deathDate = null;
        String deathDateString = scanner.nextLine();
        if (!deathDateString.isEmpty()) {
            deathDate = LocalDate.parse(deathDateString);
        }

        Human father = null, mother = null;

        printAnswer("Введите ID отца (если есть, иначе оставьте пустым):");
        String fatherIdString = scanner.nextLine();
        if (!fatherIdString.isEmpty()) {
            int fatherId = Integer.parseInt(fatherIdString);
            father = presenter.findHumanById(fatherId);
        }

        printAnswer("Введите ID матери (если есть, иначе оставьте пустым):");
        String motherIdString = scanner.nextLine();
        if (!motherIdString.isEmpty()) {
            int motherId = Integer.parseInt(motherIdString);
            mother = presenter.findHumanById(motherId);
        }

        presenter.addHuman(null, name, gender, birthDate, deathDate, father, mother); // Обновите вызов с правильными аргументами
    }

    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByGender() {
        presenter.sortByGender();
    }

    public void sortByParents() {
        presenter.sortByParents();
        printAnswer("Список отсортирован по родителям.");
    }

    public void sortByDeathDate() {
        presenter.sortByDeathDate();
        printAnswer("Список отсортирован по дате смерти.");
    }

    public void sortByChildren() {
        presenter.sortByChildren();
        printAnswer("Список отсортирован по детям.");
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
        printAnswer("Список отсортирован по дате рождения.");
    }
}

