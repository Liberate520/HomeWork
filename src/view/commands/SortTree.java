package view.commands;

import view.ConsoleUI;

public class SortTree extends Command {

    public SortTree(ConsoleUI consoleUI) {
        super("Сортировать семейное дерево ->", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().choicingSort();
    }
}



