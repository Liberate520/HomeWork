package View.RelationsMenu;

import View.ConsoleUI;

public abstract class AddRelations {
    ConsoleUI consoleUI;
    String description;

    public AddRelations(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute(int humanID);
}
