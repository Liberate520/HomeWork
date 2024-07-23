package view;

import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;
    private Menu menu;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
        this.menu = new Menu(); // Инициализация Menu
    }

    @Override
    public void showMenu() {
        menu.display(); // Вызов метода для отображения меню
    }

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    @Override
    public UserInput getUserInput() {
        String name = getUserInput("Введите имя: ");
        String birthDate = getUserInput("Введите дату рождения (в формате yyyy-mm-dd): ");
        String genderStr = getUserInput("Введите пол (MALE или FEMALE): ");
        Integer fatherId = getUserIntInput("Введите ID отца (или 0, если нет): ");
        Integer motherId = getUserIntInput("Введите ID матери (или 0, если нет): ");
        return new UserInput(name, birthDate, genderStr, fatherId != 0 ? fatherId : null, motherId != 0 ? motherId : null);
    }

    @Override
    public int getUserIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Пожалуйста, введите целое число.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}
