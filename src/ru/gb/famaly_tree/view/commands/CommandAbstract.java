package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

import java.io.IOException;

public abstract class CommandAbstract {
    String discription;
    ConsoleUI consoleUI;

    public CommandAbstract(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }

    public String getDiscription(){
        return discription;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;
}
