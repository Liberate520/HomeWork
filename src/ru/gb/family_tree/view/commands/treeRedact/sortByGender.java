package ru.gb.family_tree.view.commands.treeRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class sortByGender extends Command {
    public sortByGender(ConsoleUI consoleUI) {
        super("Дополнить элемент", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByGender();
        getConsoleUI().choiseRedactTree();
    }
}