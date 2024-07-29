package ru.gb.familytree.view.commands;

import ru.gb.familytree.view.ConsoleUI;

public class GetTreeInfo extends Command {

    public GetTreeInfo(ConsoleUI consoleUI) {
        super("Список в дереве", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getTreeListInfo();
    }
}
