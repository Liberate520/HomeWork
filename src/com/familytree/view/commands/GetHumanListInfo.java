
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class GetHumanListInfo implements Command {
    private ConsoleUI consoleUI;

    public GetHumanListInfo(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.getHumanListInfo();
    }

    @Override
    public String getDescription() {
        return "Вывести список людей";
    }
}
