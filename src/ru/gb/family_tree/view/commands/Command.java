package ru.gb.family_tree.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.gb.family_tree.view.ConsoleUI;

public abstract class Command {
    private String description;
    @SuppressWarnings("rawtypes")
    private ConsoleUI consoleUI;

    @SuppressWarnings("rawtypes")
    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    @SuppressWarnings("rawtypes")
    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute() throws FileNotFoundException, IOException, ClassNotFoundException;
}
