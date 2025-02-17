package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public  abstract class Commands {
    private ConsoleUI consoleUI;
    private String description;

    public Commands(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }

    public String getDescription() {return description;}

    public ConsoleUI getConsoleUI() {return consoleUI;}

    abstract void execute();
}
