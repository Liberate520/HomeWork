package view.commands.fileOperations;

import view.ConsoleUI;
import view.commands.Command;

public class ShowCurrentFilePath extends Command {
    public ShowCurrentFilePath(ConsoleUI consoleUI) {
        super("Показать путь к текущему файлу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().showCurrentFilePath();
    }
}
