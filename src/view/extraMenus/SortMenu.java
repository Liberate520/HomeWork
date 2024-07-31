package view.extraMenus;

import view.ConsoleUI;
import view.commands.Command;
import view.commands.sort.SortByAge;
import view.commands.sort.SortByChildrenQuantity;
import view.commands.sort.SortById;
import view.commands.sort.SortByName;

import java.util.ArrayList;
import java.util.List;

public class SortMenu {
    private List<Command> commands;

    public SortMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new SortById(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByChildrenQuantity(consoleUI));
    }

    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nМеню по сортировке:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
