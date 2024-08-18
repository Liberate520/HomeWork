package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class FindByName extends Command {

    public FindByName(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Найти по имени";
    }

    @Override
    public void execute() {
        consoleUI.findByName();
    }
}
