package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddHuman extends Command {
    private String description;
    private ConsoleUI consoleUI;

    public AddHuman(ConsoleUI consoleUI) {
        super("Add human", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}