package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class GetFamilyTree extends Commands{
    public GetFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть дерево целиком");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().getFamiliTree();
    }
}


