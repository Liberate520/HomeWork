package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.CommandInterface;

// Применяем OCP: Класс MainMenu позволяет динамически добавлять новые команды.
public class MainMenu {
    private List<CommandInterface> commands;

    public MainMenu() {
        this.commands = new ArrayList<>();
    }

    public void addCommand(CommandInterface command) {
        commands.add(command);
    }

    public String menu() {
        StringBuilder sb = new StringBuilder("\nВведите номер команды:\n");
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1).append(". ").append(commands.get(i).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        if (choice > 0 && choice <= commands.size()) {
            commands.get(choice - 1).execute();
        } else {
            System.out.println("Неверный выбор!");
        }
    }
}