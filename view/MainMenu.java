package view;

import java.util.ArrayList;
import java.util.List;

import view.commands.AddHuman;
import view.commands.AddPlace;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetFamilyTreeInfo;
import view.commands.SortByBirthDate;
import view.commands.SortByLastName;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new AddPlace(consoleUI));
        commands.add(new SortByLastName(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new GetFamilyTreeInfo(consoleUI));
        commands.add(new Finish(consoleUI));

    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nВведите номер команды:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1).append(". ").append(commands.get(i).getDescription()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }

    public int size() {
        return commands.size();
    }
}
