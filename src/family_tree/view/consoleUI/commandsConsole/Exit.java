package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class Exit extends Command {

    public Exit(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Сохранить и завершить работу";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}