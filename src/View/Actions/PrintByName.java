package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class PrintByName extends Actions{
    public PrintByName (ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Найти информацию о члене семьи по имени", consoleUI);
    }

    public void run(){
        getConsoleUI().getMember();
    }

}
