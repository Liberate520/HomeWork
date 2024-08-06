package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class AddParent extends Actions{
    public AddParent (ConsoleUI consoleUI) throws SecurityException, IOException {
        super(" Добавить родителя к информации ребенка", consoleUI);
    }

    public void run(){
        getConsoleUI().addParent();
    }

}
