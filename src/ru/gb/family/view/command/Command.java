package ru.gb.family.view.command;

import ru.gb.family.view.ConsoleUI;

public abstract class Command {
    private String name;
    private ConsoleUI consoleUI;
    public Command(String name, ConsoleUI consoleUI){
        this.name = name;
        this.consoleUI = consoleUI;
    }

    public String getName() {
        return name;
    }

    protected ConsoleUI getConsoleUI(){
        return consoleUI;
    }
    public abstract void run();

}

