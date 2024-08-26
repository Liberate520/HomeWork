package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByBirthDate extends Command {
    private String description;
    private ConsoleUI consoleUI;

    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Sort by birthdate", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDate();
    }
}