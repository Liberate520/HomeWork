package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public abstract class Actions {
    private String description;
    private ConsoleUI consoleUI;

    public Actions(String description, ConsoleUI consoleUI) throws SecurityException, IOException {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void run() throws ClassNotFoundException, IOException;
}
