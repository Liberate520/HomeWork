package family_TREE.view;

import family_TREE.view.commands.*;
import java.util.ArrayList;
import java.util.List;
import static family_TREE.view.commands.Command.command;

public class MainMenu {
    private final List<Command> commands;

    public MainMenu(Console console) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(console));
        commands.add(new GetHumanList(console));
        commands.add(new SortByName(console));
        commands.add(new SortByDeathDate(console));
        commands.add(new Finish(console));
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список: \n");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        command = commands.get(choice - 1);
        command.execute();
    }
}