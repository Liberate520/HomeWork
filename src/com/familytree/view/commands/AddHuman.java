
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }

    @Override
    public String getDescription() {
        return "Добавить человека";
    }
}
