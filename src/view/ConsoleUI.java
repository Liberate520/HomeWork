package view;

import model.family_tree.FamilyTree;
import model.human.Gender;
import presenter.Presenter;

import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private MainMenu menu;
    private FamilyTree familyTree;
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;

    public ConsoleUI() {
        menu = new MainMenu(this);
        familyTree = new FamilyTree<>();
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
    }

    @Override
    public void start() {
        greetings();
        selectItemFromMenu();
    }

    private static void greetings() {
        System.out.println("Добро пожаловать в программу семейного древа!\nПожалуйста выберите нужный Вам пункт из меню.");
    }

    private void selectItemFromMenu() {
        while (work) {
            System.out.println(menu.menu());
            String choiceStr = scanner.nextLine();
            if (isValidChoice(choiceStr, menu.size())) {
                int choice = Integer.parseInt(choiceStr);
                menu.execute(choice);
            } else {
                System.out.println("Введён неверный пункт меню.\nВведите корректный номер из меню: от 1 до " + menu.size());
            }
        }
    }

    private static boolean isValidChoice(String choiceStr, int menuSize) {
        try {
            int choice = Integer.parseInt(choiceStr);
            return choice >= 1 && choice <= menuSize;
        } catch (NumberFormatException e) {

            return false;
        }
    }

    public void finishWork() {
        work = false;
        scanner.close();
        System.out.println("До новых встреч!");
        presenter.sortById(); // Будет сохраняться дерево, отсортированное по ID
        presenter.saveTree();
    }

    public void sortById() {
        presenter.sortById();
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
        System.out.println("Укажите имя человека:");
        String name = scanner.nextLine();

        System.out.println("Укажите пол человека м/ж:");
        Gender gender = getGenderFromInput();

        System.out.println("Укажите дату рождения человека через пробел в формате ДД ММ ГГГГ:");
        LocalDate birthDate = getBirthDateFromInput();

        presenter.addHuman(name, gender, birthDate);
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    private Gender getGenderFromInput() {
        while (true) {
            String gender = scanner.nextLine().trim();
            if (gender.equalsIgnoreCase("м")) {
                return Gender.Male;
            } else if (gender.equalsIgnoreCase("ж")) {
                return Gender.Female;
            } else {
                System.out.println("Введен неправильный пол, попробуйте заново (м/ж):");
            }
        }
    }

    private LocalDate getBirthDateFromInput() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                String[] parts = input.split(" ");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);

                LocalDate birthDate = LocalDate.of(year, month, day);
                if (birthDate.isAfter(LocalDate.now())) {
                    System.out.println("Дата рождения не может быть больше текущей даты. Пожалуйста, введите корректную дату:");
                } else {
                    return birthDate;
                }
            } catch (DateTimeException | ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Неверный формат даты рождения. Пожалуйста, введите дату в формате ДД ММ ГГГГ:");
            }
        }
    }
}

//TODO реализовать возможность считывания сохранённого дерева из файла