package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать семейное древо по имени", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByName();
    }    

}
