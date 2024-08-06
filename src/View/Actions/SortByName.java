package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class SortByName extends Actions{
    public SortByName (ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Отсортировать древо по имени", consoleUI);
    }

    public void run(){
        getConsoleUI().sortByName();
    }

}
