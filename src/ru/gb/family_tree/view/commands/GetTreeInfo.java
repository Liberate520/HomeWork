package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetTreeInfo extends Command {
    public GetTreeInfo(@SuppressWarnings("rawtypes") ConsoleUI consoleUI) {
        super("Показать всё семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getTreeInfo();
    }
}