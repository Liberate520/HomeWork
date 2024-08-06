package src.View.Actions;

import java.io.IOException;

import src.View.ConsoleUI;

public class PrintTree extends Actions{
    public PrintTree (ConsoleUI consoleUI) throws SecurityException, IOException {
        super("Вывести информацию о семеном древе", consoleUI);
    }

    public void run(){
        getConsoleUI().getInfo();
    }

}
