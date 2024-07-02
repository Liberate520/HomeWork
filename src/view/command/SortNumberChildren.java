package view.command;

import view.ConsoleUI;

public class SortNumberChildren extends Command {

    public SortNumberChildren(ConsoleUI consoleUI) {
        super("Сортировать по количеству детей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortNumberChildren();
    }
}
