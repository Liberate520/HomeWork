package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public abstract class CommandForCreature<T> {
    String description;
    ConsoleUI consoleUI;

    public CommandForCreature(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }



    public abstract void execute(T creature);
}

