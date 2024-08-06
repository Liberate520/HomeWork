package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class SortByParents extends Command {
    public SortByParents(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Отсортировать по родителям";
    }

    @Override
    public void execute() {
        consoleUI.sortByParents();
    }
}
