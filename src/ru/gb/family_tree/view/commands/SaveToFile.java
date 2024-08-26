package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveToFile extends Command {
    private String description;
    private ConsoleUI consoleUI;

    public SaveToFile(ConsoleUI consoleUI) {
        super("Save family tree in file", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().save();
    }
}