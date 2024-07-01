package ru.gb.family_tree.view.commands.treeRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class sortByDob extends Command {
    public sortByDob(ConsoleUI consoleUI) {
        super("Найти элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByDob();
        getConsoleUI().choiseRedactTree();
    }
}
