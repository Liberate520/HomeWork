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
        System.out.println("5. Сохранить дерево");
        System.out.println("6. Загрузить дерево");
        System.out.println("7. Выйти");
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

    @Override
    public String getUserInput(String prompt) { // SRP: добавлен метод для получения ввода пользователя
        System.out.print(prompt);
        return scanner.next();
    }

    @Override
    public int getUserIntInput(String prompt) { // SRP: добавлен метод для получения ввода пользователя
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.next();  // Очистка неверного ввода
            System.out.print("Пожалуйста, введите число: ");
        }
        return scanner.nextInt();
    }
}
