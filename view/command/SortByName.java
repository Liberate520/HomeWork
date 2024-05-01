package view.command;

import view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super("Сортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByName();
    }
}
