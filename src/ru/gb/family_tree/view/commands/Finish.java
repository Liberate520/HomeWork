package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Finish extends Command {
    private String description;
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        super("Finish", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}