package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
