

package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class SortByBirthDate implements Command {
    private ConsoleUI consoleUI;

    public SortByBirthDate(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.sortByBirthDate();
    }

    @Override
    public String getDescription() {
        return "Сортировать по дате рождения";
    }
}
