package View;

import View.Commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<Command> commands;
    private Scanner scanner;

    public Menu() {
        this.commands = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void showMenu() {
        System.out.println("Меню:");
        for (int i = 0; i < commands.size(); i++) {
            System.out.println((i + 1) + ". " + commands.get(i).getDescription());
        }
        System.out.println((commands.size() + 1) + ". Выйти");
    }

    public int getUserChoice() {
        System.out.print("Выберите действие: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public void executeCommand(int choice) {
        if (choice > 0 && choice <= commands.size()) {
            commands.get(choice - 1).execute();
        } else if (choice == commands.size() + 1) {
            System.exit(0);
        } else {
            System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
        }
    }
}
