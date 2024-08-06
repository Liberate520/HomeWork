package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class SortByBirthday extends Actions{
    public SortByBirthday (ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Отсортировать древо по дате рождения", consoleUI);
    }

    public void run(){
        getConsoleUI().sortByBirthday();
    }

}
