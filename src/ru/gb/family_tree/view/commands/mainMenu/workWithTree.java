package ru.gb.family_tree.view.commands.mainMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class workWithTree extends Command {


    public workWithTree(ConsoleUI consoleUI) {
        super("Работа с деревом", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().choiseRedactTree();
    }
}
