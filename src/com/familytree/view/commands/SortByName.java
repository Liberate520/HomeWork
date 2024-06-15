
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }

    @Override
    public String getDescription() {
        return "Сортировать по имени";
    }
}

