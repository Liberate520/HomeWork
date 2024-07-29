package view.commands;

import view.ConsoleUi;

import java.io.IOException;

public abstract class Command {
    private String description ;
    private ConsoleUi consoleUi;

    public Command(String description, ConsoleUi consoleUi) {
        this.description = description;
        this.consoleUi = consoleUi;
    }

    public ConsoleUi getConsoleUi() {
        return consoleUi;
    }

    public String getDescription(){
        return description;
    }

    public abstract void execute() throws IOException;
}
