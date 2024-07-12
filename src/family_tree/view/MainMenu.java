package family_tree.view;

import family_tree.view.commands.*;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commands;

    public MainMenu (UserInterface userInterface) {
        commands = new ArrayList<>();
        commands.add(new AddHuman(userInterface));
        commands.add(new SetParents(userInterface));
        commands.add(new PrintAllHumans(userInterface));
        commands.add(new SortHumansByName(userInterface));
        commands.add(new SortHumansByDateBirth(userInterface));
        commands.add(new FindHuman(userInterface));
        commands.add(new Finish(userInterface));
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

    public void execute (int choice) {
        Command command = commands.get(choice - 1);
        command.execute();
    }
}
