package ru.gb.family_tree.view;

import ru.gb.family_tree.model.humen.Gender;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public int displayMenuAndGetChoice() {
        System.out.println("Меню:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Удалить человека");
        System.out.println("3. Сортировать по имени");
        System.out.println("4. Сортировать по дате рождения");
        System.out.println("5. Показать информацию о семейном дереве");
        System.out.println("6. Добавить родителя к человеку");
        System.out.println("7. Добавить ребенка к человеку");
        System.out.println("0. Выход");
        System.out.print("Введите ваш выбор: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: Введите корректный номер.");
            scanner.next(); // очистка некорректного ввода
        }

        return scanner.nextInt();
    }

    public String promptForString(String message) {
        System.out.print(message + " ");
        return scanner.next();
    }

    public int promptForInt(String message) {
        System.out.print(message + " ");
        while (!scanner.hasNextInt()) {
            System.out.println("Ошибка: Введите корректное число.");
            scanner.next(); // очистка некорректного ввода
        }
        return scanner.nextInt();
    }

    public boolean promptForBoolean(String message) {
        System.out.print(message + " ");
        String input = scanner.next().toLowerCase();
        return input.equals("да") || input.equals("yes");
    }

    public Gender promptForGender(String message) {
        System.out.print(message + " ");
        String input = scanner.next().toLowerCase();
        while (!input.equals("мужской") && !input.equals("женский")) {
            System.out.println("Ошибка: Введите 'мужской' или 'женский'.");
            input = scanner.next().toLowerCase();
        }
        return input.equals("мужской") ? Gender.Male : Gender.Female;
    }

    public LocalDate promptForDate(String message) {
        System.out.print(message + " ");
        while (true) {
            try {
                String input = scanner.next();
                return LocalDate.parse(input);
            } catch (DateTimeParseException e) {
                System.out.println("Ошибка: Введите корректную дату (гггг-мм-дд).");
            }
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void close() {
        scanner.close();
    }
}
