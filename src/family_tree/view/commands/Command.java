package family_tree.view.commands;

import family_tree.view.ConsoleUI;

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
