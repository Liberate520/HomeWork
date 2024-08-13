package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class SortByChildren extends Actions {
    public SortByChildren(ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Отсортировать древо по количеству детей", consoleUI);
    }

    public void run() {
        getConsoleUI().sortByChildren();
    }
}
