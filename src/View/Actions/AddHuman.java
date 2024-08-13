package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class AddHuman extends Actions {
    public AddHuman(ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Добавить нового члена семьи", consoleUI);
    }

    public void run() {
        getConsoleUI().addHuman();
    }
}
