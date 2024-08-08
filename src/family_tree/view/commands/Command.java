package family_tree.view.commands;

import family_tree.view.ConsoleUI;

import java.io.UnsupportedEncodingException;

public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();
}
