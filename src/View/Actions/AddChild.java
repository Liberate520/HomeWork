package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class AddChild extends Actions{
    public AddChild (ConsoleUI consoleUI) throws SecurityException, IOException {
        super(" Добавить ребенка к информации родителя", consoleUI);
    }

    public void run(){
        getConsoleUI().addChild();
    }

}
