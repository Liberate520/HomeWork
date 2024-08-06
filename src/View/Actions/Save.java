package src.View.Actions;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.View.ConsoleUI;

public class Save extends Actions{
    public Save (ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Сохранить семейное древо", consoleUI);
    }

    public void run() throws FileNotFoundException, IOException{
        getConsoleUI().save();
    }

}
