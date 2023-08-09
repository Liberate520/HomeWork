package view.commands;

import view.ConsoleUI;

public class Finish extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Finish application";

    }

    public void execute(){
        getConsoleUI().finish();
    }

    public String getDescription(){
        return description;
    }
}
