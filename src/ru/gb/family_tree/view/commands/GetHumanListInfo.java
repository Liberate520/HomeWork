package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetHumanListInfo extends Command {
    private String description;
    private ConsoleUI consoleUI;

    public GetHumanListInfo(ConsoleUI consoleUI) {
        super("Get family tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanListInfo();
    }
}