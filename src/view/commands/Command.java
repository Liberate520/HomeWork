package view.commands;

import view.ConsoleUI;

import java.util.ArrayList;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    ConsoleUI getConsoleUI(){
        return consoleUI;
    }

    public abstract void execute();
}
