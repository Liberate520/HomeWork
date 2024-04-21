package familytree.view.commands;

import familytree.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать по имени";
    }

    public void execute() {
        consoleUI.sortByName();
    }
}

