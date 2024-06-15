
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public abstract class Command {
    private ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public ConsoleUI getConsoleUI() {
        return consoleUI;
    }

    public abstract void execute();

    public abstract String getDescription();
}
