
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class AddDog extends Command {
    public AddDog(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addDog();
    }

    @Override
    public String getDescription() {
        return "Добавить собаку";
    }
}
