package ru.gb.family_tree.view.commands.treeRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class sortById extends Command {
    public sortById(ConsoleUI consoleUI) {
        super("Удалить элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortById();
        getConsoleUI().choiseRedactTree();
    }
}