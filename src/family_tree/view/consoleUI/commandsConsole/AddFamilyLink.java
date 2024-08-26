package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class AddFamilyLink extends Command {

    public AddFamilyLink(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Добавить родственную связь";
    }

    @Override
    public void execute() {
        consoleUI.addFamilyLink();
    }
}
