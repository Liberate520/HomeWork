package view.commands;

import view.ConsoleUI;

public abstract class Commands {
    private final String description;
    private ConsoleUI consoleUI;

    protected Commands(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
