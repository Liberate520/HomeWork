package ru.gb.familytree.view.commands;

import ru.gb.familytree.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super("Сортировка по имени", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
