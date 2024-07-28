package view.commands.fileOperations;

import view.ConsoleUI;
import view.commands.Command;

public class SetCustomPath extends Command {
    public SetCustomPath(ConsoleUI consoleUI) {
        super("Изменить путь сохранения файла", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setCustomPath();
    }
}