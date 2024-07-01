package ru.gb.family_tree.view.commands.treeRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class sortByName extends Command {


    public sortByName(ConsoleUI consoleUI) {
        super("Создать новый элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByName();
        getConsoleUI().choiseRedactTree();
    }
}
