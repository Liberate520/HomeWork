package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortBySpouse extends Command {
    public SortBySpouse(@SuppressWarnings("rawtypes") ConsoleUI consoleUI) {
        super("Отсортировать список по семейному положению", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortBySpouse();
    }
}
