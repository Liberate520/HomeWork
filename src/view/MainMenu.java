package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();

        commands.add(new GetTreeInfo(consoleUI));
        commands.add(new AddFirst(consoleUI));
        commands.add(new LoadTree(consoleUI));
        commands.add(new AddHuman(consoleUI));
        commands.add(new AddWedding(consoleUI));
        commands.add(new AddDivorce(consoleUI));
        commands.add(new AddChild(consoleUI));
        commands.add(new AddBirthDate(consoleUI));
        commands.add(new AddDeathDate(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortById(consoleUI));
        commands.add(new SortByAge(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new SaveTree(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1);
            sb.append(". ");
            sb.append(commands.get(i).getDescription());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}