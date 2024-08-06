package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class Load extends Actions{
    public Load (ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Загрузить фамильное древо", consoleUI);
    }

    public void run() throws ClassNotFoundException, IOException{
        getConsoleUI().load();
    }

}
