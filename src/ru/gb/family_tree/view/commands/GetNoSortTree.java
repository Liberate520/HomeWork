package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class GetNoSortTree extends Command {
    public GetNoSortTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести неотсортированный список членов семьи";
    }
    @Override
    public void execute() {
        consoleUI.getNoSortTree();
    }
}


//----------------------------------------------------------------
