package View.Commands;

import View.ConsoleUI;

public class SortByChildrenNumber extends Command{

    public SortByChildrenNumber(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать семейное дерево по количеству детей";
    }

    public void execute() {
        consoleUI.sortByChildrenNumber();
    }
}
