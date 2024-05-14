package view.Commands;

import view.ConsoleUI;

public class SortByID extends Command {
    public SortByID(ConsoleUI consoleUI) {
        super("Сортировать по ID", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByID();
    }
}
