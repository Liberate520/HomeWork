package ru.gb.family_tree.view.commands.mainMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class loadTree extends Command {
    public loadTree(ConsoleUI consoleUI) {
        super("Загрузить дерево", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().clearConsole();
        getConsoleUI().loadTree();
        getConsoleUI().clearConsole();
    }
}
