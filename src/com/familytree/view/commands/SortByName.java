

package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class SortByName implements Command {
    private ConsoleUI consoleUI;

    public SortByName(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }
}
