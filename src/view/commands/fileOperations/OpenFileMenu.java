package view.commands.fileOperations;

import view.ConsoleUI;
import view.commands.Command;

public class OpenFileMenu extends Command {
    public OpenFileMenu(ConsoleUI consoleUI) {
        super("Файловый менеджер семейного древа", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().openFileMenu();
    }
}
