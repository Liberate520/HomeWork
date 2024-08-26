package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class ReadFromFile extends Command {
    private String description;
    private ConsoleUI consoleUI;

    public ReadFromFile(ConsoleUI consoleUI) {
        super("Load family tree from file", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().read();
    }
}