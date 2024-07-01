package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

import java.io.IOException;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription(){
        return description;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;
}
