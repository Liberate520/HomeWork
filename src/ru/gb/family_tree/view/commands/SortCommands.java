package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortCommands extends Command {

    public SortCommands(ConsoleUI consoleUI) {
        super("Сортировать", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortMenuShow();
    }
}
