package View.Commands;

import View.ConsoleUI;

public abstract class Command {
    private final String key;
    private final String description;
    private final ConsoleUI consoleUI;

    public Command(String key, String description, ConsoleUI consoleUI){
        this.key = key;
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public String getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
