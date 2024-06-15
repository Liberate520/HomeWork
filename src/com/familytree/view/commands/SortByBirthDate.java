
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class SortByBirthDate extends Command {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDate();
    }

    @Override
    public String getDescription() {
        return "Сортировать по дате рождения";
    }
}
