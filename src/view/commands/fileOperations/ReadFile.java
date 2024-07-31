package view.commands.fileOperations;

import view.ConsoleUI;
import view.commands.Command;

public class ReadFile extends Command {
    public ReadFile(ConsoleUI consoleUI) {
        super("Импортировать существующее дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().importFile();
    }
}
