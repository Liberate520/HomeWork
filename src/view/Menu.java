package view;

import view.commands.*;
import view.util.ConsoleColors;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Command> commandList;

    public Menu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new GetHumanList(consoleUI));
        commandList.add(new AddHuman(consoleUI));
        commandList.add(new GetHumanList(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByDayOfBirth(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String createMenuItem(
            Integer number, String title
    ) {
        StringBuilder sb = new StringBuilder();
        sb.append(ConsoleColors.YELLOW_BOLD);
        sb.append(number);
        sb.append(". ");
        sb.append(ConsoleColors.RESET);
        sb.append(title);
        sb.append("\n");
        return sb.toString();
    }

    public String menu() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            sb.append(createMenuItem(i + 1, commandList.get(i).getDescription()));
        }
        return sb.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {
        return commandList.size();
    }
}