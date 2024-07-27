package view.menu;

import view.ConsoleUI;
import view.listmenu.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuHuman implements Menu {
    private List<Command> commands;

    public MenuHuman(ConsoleUI consoleUI) {
        commands = new ArrayList<>();
        commands.add(new NewHuman(consoleUI));
        if(consoleUI.getPresenter().getFamilyTreeSize() < 2) {
            commands.add(new FamilyConnection(consoleUI));
        }
        commands.add(new ShowAllHumans(consoleUI));
        commands.add(new SaveFamilyTree(consoleUI));
        if (consoleUI.getPresenter().getServiceFamilyTree().getFileHandler().isFileExists()) {
            commands.add(new ReadFamilyTree(consoleUI));
        }
        commands.add(new ExitMenu(consoleUI));
    }

    public String showMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commands.get(choice - 1);
        command.execute();
    }

    public int size() {
        return commands.size();
    }
}
