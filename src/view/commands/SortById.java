package view.commands;

import view.ConsoleUI;

public class SortById extends Command {
    public SortById(ConsoleUI consoleUI) {
        super("Сортировка семейного древа по Id", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortById();
    }
}