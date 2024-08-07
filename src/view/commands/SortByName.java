package view.commands;

import view.ConsoleUI;

public class SortByName extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public SortByName(ConsoleUI consoleUI) {
        super("Сортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
