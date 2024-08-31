package familytree.factory;

import familytree.commands.*;
import familytree.service.FamilyTreeServiceInterface;
import familytree.ui.UserInterface;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory implements CommandFactoryInterface {
    private final Map<String, Command> commands = new HashMap<>();
    private final FamilyTreeServiceInterface familyTreeService;
    private final UserInterface userInterface;

    public CommandFactory(FamilyTreeServiceInterface familyTreeService, UserInterface userInterface) {
        this.familyTreeService = familyTreeService;
        this.userInterface = userInterface;
        initializeCommands();
    }

    private void initializeCommands() {
        commands.put("1", new AddMemberCommand(familyTreeService, userInterface));
        commands.put("2", new FindMemberCommand(familyTreeService, userInterface));
        commands.put("3", new AddParentChildRelationshipCommand(familyTreeService, userInterface));
        commands.put("4", new PrintSortedByNameCommand(familyTreeService, userInterface));
        commands.put("5", new PrintSortedByDateOfBirthCommand(familyTreeService, userInterface));
        commands.put("6", new SaveToFileCommand(familyTreeService, userInterface));
        commands.put("7", new LoadFromFileCommand(familyTreeService, userInterface));
        commands.put("0", new ExitCommand());
    }

    public Command getCommand(String commandKey) {
        return commands.getOrDefault(commandKey, new UnknownCommand(userInterface));
    }
}