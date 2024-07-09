package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class SortByData extends Commands{
    public SortByData(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть все имена из дерева отсортированные по дате");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().sortByData();
    }
}




