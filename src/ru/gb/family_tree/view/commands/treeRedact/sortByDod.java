package ru.gb.family_tree.view.commands.treeRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class sortByDod extends Command {
    public sortByDod(ConsoleUI consoleUI) {
        super("Найти элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByDod();
        getConsoleUI().choiseRedactTree();

    }
}
