package family_tree.view.command;

import family_tree.view.ConsoleUI;

public abstract class Command {
    private final String description;
    private final ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI, String description) {
        this.consoleUI = consoleUI;
        this.description = description;
    }


    public String getDescription() { return description; }

    protected ConsoleUI getConsoleUI() { return consoleUI; }

    public abstract void execute();

}
