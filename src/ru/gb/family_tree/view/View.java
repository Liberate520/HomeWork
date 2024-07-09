package ru.gb.family_tree.view;

import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public int displayMenuAndGetChoice() {
        System.out.println("Система управления семейным деревом");
        System.out.println("1. Добавить человека");
        System.out.println("2. Получить братьев и сестер");
        System.out.println("3. Найти по имени");
        System.out.println("4. Установить брак");
        System.out.println("5. Развестись");
        System.out.println("6. Удалить человека");
        System.out.println("7. Сортировать по имени");
        System.out.println("8. Сортировать по дате рождения");
        System.out.println("9. Показать информацию о семейном дереве");
        System.out.println("0. Выйти");
        System.out.print("Введите ваш выбор: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public long getLongInput(String prompt) {
        System.out.print(prompt);
        return Long.parseLong(scanner.nextLine());
    }

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public <E> void displayList(List<E> list, String message) {
        System.out.println(message);
        for (E item : list) {
            System.out.println(item);
        }
    }

    public void close() {
        scanner.close();
    }
    public String promptForString(String prompt) {
        System.out.print(prompt + " ");
        return scanner.nextLine();
    }
    public int promptForInt(String prompt) {
        int input = 0;
        boolean validInput = false;

        do {
            try {
                System.out.print(prompt + " ");
                input = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат числа. Попробуйте снова.");
            }
        } while (!validInput);

        return input;
    }
    public boolean promptForBoolean(String prompt) {
        boolean input = false;
        boolean validInput = false;

        do {
            String userInput = promptForString(prompt + " (да/нет)").toLowerCase();
            if (userInput.equals("да") || userInput.equals("yes")) {
                input = true;
                validInput = true;
            } else if (userInput.equals("нет") || userInput.equals("no")) {
                input = false;
                validInput = true;
            } else {
                System.out.println("Неверный ввод. Введите 'да' или 'нет'.");
            }
        } while (!validInput);

        return input;
    }
}