package src.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import src.presenter.Presenter;
import src.view.ConsoleUI;


public abstract class Command {
    
    Scanner scanner;
    String description;
    ConsoleUI consoleUI;
    Presenter presenter;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;

    }

    public String getDescription(){
        return description;
    }

    public abstract void execute() throws FileNotFoundException, IOException, ClassNotFoundException;

}
