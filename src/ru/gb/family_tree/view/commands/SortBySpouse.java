package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortBySpouse extends Command {
    public SortBySpouse(ConsoleUI consoleUI) {
        super("Отсортировать семейное древо по семейному положению", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortBySpouse();
    }
}
