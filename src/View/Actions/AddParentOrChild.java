package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class AddParentOrChild extends Actions{

    public AddParentOrChild (ConsoleUI consoleUI) throws SecurityException, IOException {
        super(" Добавить информацию о родителях и детях", consoleUI);
    }

    public void run(){
        getConsoleUI().addParentOrChild();
    }

}
