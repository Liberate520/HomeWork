package view.commands;

import view.ConsoleView;

public abstract class Command {
    private final String description;
    private final ConsoleView consoleView;

    public Command(String description, ConsoleView consoleView) {
        this.description = description;
        this.consoleView = consoleView;
    }

    public String getDescription() {
        return description;
    }

    protected ConsoleView getConsoleView() {
        return consoleView;
    }

    public abstract void execute();
}
