package familytree.presenter;

import familytree.commands.Command;
import familytree.commands.ExitCommand;
import familytree.factory.CommandFactoryInterface;
import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.UserInterface;

public class FamilyTreePresenter {
    private final FamilyTreeServiceInterface familyTreeService;
    private final UserInterface userInterface;
    private final CommandFactoryInterface commandFactory;

    public FamilyTreePresenter(FamilyTreeServiceInterface familyTreeService, UserInterface userInterface, CommandFactoryInterface commandFactory) {
        this.familyTreeService = familyTreeService;
        this.userInterface = userInterface;
        this.commandFactory = commandFactory;
    }

    public void start() {
        while (true) {
            handleUserInput();
        }
    }

    private void handleUserInput() {
        userInterface.showMenu();
        String commandKey = userInterface.getUserInput("Введите команду: ");
        Command command = commandFactory.getCommand(commandKey);
        command.execute();
        if (command instanceof ExitCommand) {
            return;
        }
    }
}