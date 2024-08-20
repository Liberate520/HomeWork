package View;

import View.Commands.Command;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commands;

    public Menu() {
        this.commands = new ArrayList<>();
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
