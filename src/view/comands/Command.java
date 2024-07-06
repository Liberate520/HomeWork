package view.comands;

import view.ConsoleUI;

public abstract class Command {
    private  String description;
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();
}
