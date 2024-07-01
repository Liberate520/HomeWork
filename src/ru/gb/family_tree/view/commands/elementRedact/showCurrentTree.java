package ru.gb.family_tree.view.commands.elementRedact;

import ru.gb.family_tree.view.ConsoleUI;

public class showCurrentTree extends Command{
    public showCurrentTree(ConsoleUI consoleUI) {
        super("Посмотреть текущее дерево", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().showCurrentTree();
    }
}
