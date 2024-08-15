package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public abstract class Command {
    private String description;
    private ConsoleUI cons;

    public Command(String descript, ConsoleUI cons) {
        this.cons = cons;
        this.description = descript;
    }

    public String getDescription() {
        return description;
    }

    public ConsoleUI getConsole() {
        return cons;
    }

    public abstract void execute();
}
