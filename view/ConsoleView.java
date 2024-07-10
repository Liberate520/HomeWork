package view;

import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("1. Добавить человека");
        System.out.println("2. Показать дерево");
        System.out.println("3. Сортировать по имени");
        System.out.println("4. Сортировать по дате рождения");
        System.out.println("5. Выйти");
        System.out.print("Выберите опцию: ");
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void displayError(String errorMessage) {
        System.err.println(errorMessage);
    }

    public int getUserChoice() {
        while (!scanner.hasNextInt()) {
            scanner.next();  // Очистка неверного ввода
            System.out.print("Пожалуйста, введите номер опции: ");
        }
        return scanner.nextInt();
    }

    public String getUserInput() {
        return scanner.next();
    }

    public int getUserIntInput() {
        while (!scanner.hasNextInt()) {
            scanner.next();  // Очистка неверного ввода
            System.out.print("Пожалуйста, введите число: ");
        }
        return scanner.nextInt();
    }
}
