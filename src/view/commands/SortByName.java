package view.commands;

import view.ConsoleUI;

public class SortByName extends Commands {

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать родственников по имени.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
