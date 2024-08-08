

package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class Finish implements Command {
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }

    @Override
    public String getDescription() {
        return "Завершить работу";
    }
}
