package view;

import view.menu.*;

import java.util.ArrayList;
import java.util.List;

public class UserMenuHandler {
    private List<MenuCommand> menuCommands;
    public UserMenuHandler(UserInterface userInterface) {
        menuCommands = new ArrayList<>();
        menuCommands.add(new AddPersonAction(userInterface));
        menuCommands.add(new FindByNameAction(userInterface));
        menuCommands.add(new DisplayTreeAction(userInterface));
        menuCommands.add(new SortByIdAction(userInterface));
        menuCommands.add(new SortByNameAction(userInterface));
        menuCommands.add(new SortByBirthDateAction(userInterface));
        menuCommands.add(new RemovePersonAction(userInterface));
        menuCommands.add(new ExitAction(userInterface));
    }

    public String getMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Что вы хотите сделать?\n");
        for (int i = 0; i < menuCommands.size(); i++) {
            sb.append((i + 1)).append(". ").append(menuCommands.get(i).getDescription()).append("\n");
        }
        return sb.toString();
    }

    public void executeCommand(int commandNumber) {
        MenuCommand menuCommand = menuCommands.get(commandNumber - 1);
        menuCommand.execute();
    }

    public int size() {
        return menuCommands.size();
    }
}
