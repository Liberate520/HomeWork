package ru.gb.family_tree.view.commands.mainMenu;

import ru.gb.family_tree.view.ConsoleUI;

public class saveTree extends Command {
    public saveTree(ConsoleUI consoleUI) {
        super("Сохранить дерево", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().clearConsole();
        getConsoleUI().saveTree();
        getConsoleUI().clearConsole();
    }
}