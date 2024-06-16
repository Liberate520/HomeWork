package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(@SuppressWarnings("rawtypes") ConsoleUI consoleUI) {
        super("Отсортировать список по имени", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByName();
    }    

}
