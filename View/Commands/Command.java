package View.Commands;

import View.ConsoleWork;

public abstract class Command {
    String description;
    ConsoleWork consoleWork;

    public Command(ConsoleWork consoleWork) {
        this.consoleWork = consoleWork;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}