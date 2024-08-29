package ru.gb.family_tree.view;

import ru.gb.family_tree.view.command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new GetTreeInfoCommand(consoleUI));
        commands.add(new SortByIdCommand(consoleUI));
        commands.add(new SortByNameCommand(consoleUI));
        commands.add(new SortByAgeCommand(consoleUI));
        commands.add(new SortByBirthDayCommand(consoleUI));
        commands.add(new GetChildrenInfoCommand(consoleUI));
        commands.add(new DeviderCommand(consoleUI));
        commands.add(new AddHumanCommand(consoleUI));
        commands.add(new SetDeathDayCommand(consoleUI));
        commands.add(new setHumanFatherCommand(consoleUI));
        commands.add(new setHumanMotherCommand(consoleUI));
        commands.add(new WeddingCommand(consoleUI));
        commands.add(new DivorceCommand(consoleUI));
        commands.add(new Remove(consoleUI));
        commands.add(new DeviderCommand(consoleUI));
        commands.add(new CreateFamilyTreeCommand(consoleUI));
        commands.add(new SaveTreeCommand(consoleUI));
        commands.add(new RestoreTree(consoleUI));
        commands.add(new DeviderCommand(consoleUI));
        commands.add(new StopCommand(consoleUI));
    }

    public String menu() {
        StringBuilder result = new StringBuilder();
        result.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            if (i != 6 && i != 14 && i != 18) {
                result.append(i + 1)
                        .append(". ");
            }
            result.append(commands.get(i).getDescription())
                    .append("\n");
        }
        result.append("\n").append("Выберите пункт меню: ");
        return result.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
