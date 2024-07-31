package view.commands.fileOperations;

import view.ConsoleUI;
import view.commands.Command;

public class SaveFile extends Command {
    public SaveFile(ConsoleUI consoleUI) {
        super("Сохранить дерево в файл", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().save();
    }
}