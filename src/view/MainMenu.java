package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new FindByName(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new SortById(consoleUI));
        commands.add(new FinishWork(consoleUI));
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            sb.append(i + 1)
                    .append(". ")
                    .append(commands.get(i).getDescription())
                    .append("\n");
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
