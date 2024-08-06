package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public abstract class Command {
    private final String description;
    ConsoleUI consoleUI;

    protected Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }

    public String getDescription(){
        return description;
    }

    public abstract void execute();

}
