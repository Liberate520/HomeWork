package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public SortByAge(ConsoleUI consoleUI) {
        super("Сортировать по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}