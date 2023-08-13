package view.Commands;

import view.ConsoleUI;

public abstract class Command {
    private String description;
    ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }
    
        public String getDescription(){
            return description;
        }
    public abstract void execute();
}
