package family_tree.view;

import family_tree.view.command.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;
    public MainMenu(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(consoleUI));
        commands.add(new AddChild(consoleUI));
        commands.add(new SetMother(consoleUI));
        commands.add(new SetFather(consoleUI));
        commands.add(new GetHumanListInfo(consoleUI));
        commands.add(new SortByName(consoleUI));
        commands.add(new SortByBirthday(consoleUI));
        commands.add(new Finish(consoleUI));
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Μενώ:\n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");

        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        Command command = commands.get(choice - 1);
        command.execute();
    }
}
