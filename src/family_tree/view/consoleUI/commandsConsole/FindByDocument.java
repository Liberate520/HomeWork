package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class FindByDocument extends Command {

    public FindByDocument(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Найти по документу";
    }

    @Override
    public void execute() {
        consoleUI.findByDocument();
    }
}
