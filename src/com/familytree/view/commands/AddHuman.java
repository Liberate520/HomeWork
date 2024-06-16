
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class AddHuman implements Command {
    private ConsoleUI consoleUI;

    public AddHuman(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.addHuman();
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }
}

