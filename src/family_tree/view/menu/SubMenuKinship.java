package family_tree.view.menu;

import java.util.ArrayList;
import java.util.List;

import family_tree.view.ConsoleUI;
import family_tree.view.commands.Back;
import family_tree.view.commands.Command;
import family_tree.view.commands.add.kinship.AddChildren;
import family_tree.view.commands.add.kinship.AddParents;

public class SubMenuKinship implements Menu {
    private List<Command> commandList;

    public SubMenuKinship(ConsoleUI consoleUI) {
        this.commandList = new ArrayList<>();
        this.commandList.add(new AddParents(consoleUI));
        this.commandList.add(new AddChildren(consoleUI));
        this.commandList.add(new Back(consoleUI));
    }

    @Override
    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public int getSize() {
        return commandList.size();
    }

    @Override
    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }
}
