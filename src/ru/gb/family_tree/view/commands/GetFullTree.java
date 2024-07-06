package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetFullTree extends Commands{
    public GetFullTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать дерево.";
    }

    @Override
    public void execute() {
        consoleUI.getFullTree();
    }
}
