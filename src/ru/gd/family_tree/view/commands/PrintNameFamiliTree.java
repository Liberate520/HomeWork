package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class PrintNameFamiliTree extends Commands{
    public PrintNameFamiliTree(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть все имена из дерева");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().printNameFamiliTree();
    }
}


