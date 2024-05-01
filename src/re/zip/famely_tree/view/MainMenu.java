package re.zip.famely_tree.view;
import re.zip.famely_tree.view.command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new GetFamelyListInfo(consoleUI));
        commands.add(new SortByBirthDate(consoleUI));
        commands.add(new SortByFirstName(consoleUI));
        commands.add(new SortByFamelyName(consoleUI));
        commands.add(new SetWeddding(consoleUI));
        commands.add(new LoadFromFile(consoleUI));
        commands.add(new SaveToFile(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Меню:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }

    public void execute(int choise) {
        Command command = commands.get(choise - 1);
        command.execute();
    }
}
