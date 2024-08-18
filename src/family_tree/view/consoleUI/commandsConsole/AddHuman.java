package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Добавить человека";
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
