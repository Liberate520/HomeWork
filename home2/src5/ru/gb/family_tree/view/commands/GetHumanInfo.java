package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetHumanInfo extends Command {
    public GetHumanInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить информацию о людях";
    }

    @Override
    public void execute() {
        consoleUI.getHumanListInfo();
    }
}

