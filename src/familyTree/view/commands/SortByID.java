package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class SortByID extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public SortByID(ConsoleUI consoleUI) {
        super("Сортировать по ID", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByID();
    }
}
