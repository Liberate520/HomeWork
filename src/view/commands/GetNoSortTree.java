package view.commands;

import view.ConsoleUI;

public class GetNoSortTree extends Command {
    public GetNoSortTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести неотсортированный список";
    }
    @Override
    public void execute() {
        consoleUI.getNoSortTree();
    }
}
