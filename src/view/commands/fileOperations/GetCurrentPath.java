package view.commands.fileOperations;

import view.ConsoleUI;
import view.commands.Command;

public class GetCurrentPath extends Command {
    public GetCurrentPath(ConsoleUI consoleUI) {
        super("Показать текущий путь сохранения файла", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getCurrentPath();
    }
}