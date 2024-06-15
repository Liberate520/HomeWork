
package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class GetHumanListInfo extends Command {
    public GetHumanListInfo(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().printHumanList(getConsoleUI().getFamilyTreePresenter().getNodes());
    }

    @Override
    public String getDescription() {
        return "Вывести список людей";
    }
}
