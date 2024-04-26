package view.commands;

import view.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить семейное древо в файл", consoleUI);
    }

    public void execute() {
        getConsoleUI().saveTree();
    }
}