package ru.gb.family_tree.view;

import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    @Override
    public void start() {
        clearConsole();
        userHourHi();
        String choice1, choice2;
        do {
            showMainMenu();
            choice1 = scanner.nextLine();
            switch (choice1) {
                case "1":
                    clearConsole();
                    showEditMenu();
                    choice2 = scanner.nextLine();
                    handleEditMenuChoice(choice2);
                    break;
                case "2":
                    clearConsole();
                    showTreeMenu();
                    choice2 = scanner.nextLine();
                    handleTreeMenuChoice(choice2);
                    break;
                case "3":
                    clearConsole();
                    userHourBye();
                    break;
                default:
                    System.out.println("Некорректный выбор, попробуйте ещё раз!");
            }
        } while (!"3".equals(choice1));
    }

    private void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    private void userHourHi() {
        int hour = LocalDateTime.now().getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Доброе утро!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Добрый день!");
        } else if (hour >= 18 && hour <= 23) {
            System.out.println("Добрый вечер!");
        } else {
            System.out.println("Добрая ночь!");
        }
    }

    private void userHourBye() {
        int hour = LocalDateTime.now().getHour();
        if (hour >= 5 && hour < 12) {
            System.out.println("Доброго утра!");
        } else if (hour >= 12 && hour < 18) {
            System.out.println("Доброго дня!");
        } else if (hour >= 18 && hour <= 23) {
            System.out.println("Доброго вечера!");
        } else {
            System.out.println("Доброй ночи!");
        }
    }

    private void showMainMenu() {
        System.out.println("Выберите раздел:");
        System.out.println("1. Редактирование элементов");
        System.out.println("2. Редактирование дерева");
        System.out.println("3. Завершить работу");
    }

    private void showEditMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1. Создать шаблон");
        System.out.println("2. Удалить шаблон");
        System.out.println("3. Дополнить шаблон");
        System.out.println("4. Посмотреть список шаблонов");
    }

    private void handleEditMenuChoice(String choice) {
        // Здесь должна быть логика обработки выбора пользователя
    }

    private void showTreeMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1. Добавить шаблон в дерево");
        System.out.println("2. Удалить шаблон из дерева");
        System.out.println("3. Выбрать метод сортировки");
        System.out.println("4. Посмотреть текущее дерево");
    }

    private void handleTreeMenuChoice(String choice) {
        // Здесь должна быть логика обработки выбора пользователя
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}