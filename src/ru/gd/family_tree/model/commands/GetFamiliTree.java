package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class GetFamiliTree extends Commands{
    public GetFamiliTree(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть дерево целиком");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().getFamiliTree();
    }
}


