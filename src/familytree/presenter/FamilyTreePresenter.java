package familytree.presenter;

import familytree.commands.Command;
import familytree.factory.CommandFactory;
import familytree.service.FamilyTreeService;
import familytree.ui.UserInterface;

public class FamilyTreePresenter {
    private final FamilyTreeService familyTreeService;
    private final UserInterface userInterface;
    private final CommandFactory commandFactory;

    public FamilyTreePresenter(FamilyTreeService familyTreeService, UserInterface userInterface) {
        this.familyTreeService = familyTreeService;
        this.userInterface = userInterface;
        this.commandFactory = new CommandFactory(familyTreeService, userInterface);
    }

    public void handleUserInput() {
        while (true) {
            userInterface.showMenu();
            String commandKey = userInterface.getUserInput("Введите команду: ");
            Command command = commandFactory.getCommand(commandKey);
            command.execute();
        }
    }
}