package view.commands;

import view.ConsoleUI;

public class SaveFile extends Command {
    public SaveFile(ConsoleUI consoleUI) {
        super("Сохранить дерево в файл", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().save();
    }
}