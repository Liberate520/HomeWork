package family_tree.view;

import java.util.ArrayList;
import java.util.List;

import family_tree.view.command.AddCreateRelationshipsCommand;
import family_tree.view.command.AddHuman;
import family_tree.view.command.Command;
import family_tree.view.command.Finish;
import family_tree.view.command.GetHumanListInfo;
import family_tree.view.command.LoadTreeFromFile;
import family_tree.view.command.SaveTreeToFile;
import family_tree.view.command.SortByAge;
import family_tree.view.command.SortByName;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new LoadTreeFromFile(consoleUI));
        commands.add(new SaveTreeToFile(consoleUI));
        commands.add(new AddCreateRelationshipsCommand(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String getMenu() {
        StringBuilder builder = new StringBuilder();
        builder.append("Добро пожаловать в моё семейное дерево!\n");
        for (int i = 0; i < commands.size(); i++) {
            builder.append(i + 1).append(". ").append(commands.get(i).getDescription()).append("\n");
        }
        return builder.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int getCommandsSize() {
        return commands.size();
    }
    
}
