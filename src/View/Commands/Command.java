package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public abstract class Command<T> {
    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute();

    public abstract void execute(Human human);
}
