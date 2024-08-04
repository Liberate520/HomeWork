package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class SortByChildren extends Command {
    public SortByChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Отсортировать по детям";
    }

    @Override
    public void execute() {
        consoleUI.sortByChildren(); // Метод для сортировки по детям
    }
}
