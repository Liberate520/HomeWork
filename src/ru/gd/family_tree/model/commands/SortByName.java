package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class SortByName extends Commands{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть все имена из дерева отсортированные по имени");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().sortByName();
    }
}



