package view.commands;

import view.ConsoleUI;

public class LoadTree extends Command {
    public LoadTree(ConsoleUI consoleUI) {
        super("Загрузить семейное древо из файла", consoleUI);
    }

    public void execute() {
        getConsoleUI().loadSaveTree();
    }
}