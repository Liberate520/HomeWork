package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(ConsoleView consoleView) {
        commands = new ArrayList<>();
        commands.add(new RegisterUser(consoleView));
        commands.add(new AuthenticateUser(consoleView));
        commands.add(new AddWOD(consoleView));
        commands.add(new AddResult(consoleView));
        commands.add(new ViewAllWODs(consoleView));
        commands.add(new ViewResultsByWOD(consoleView));
        commands.add(new ViewResultsByAthlete(consoleView));
        commands.add(new ViewSortedAthletes(consoleView));
        commands.add(new Finish(consoleView));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
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
