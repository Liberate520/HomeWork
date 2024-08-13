package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class Finish extends Actions {
    public Finish(ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Выход", consoleUI);
    }

    public void run() {
        getConsoleUI().stop();
    }
}
