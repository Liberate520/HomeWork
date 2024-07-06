package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandPrintFamalyTree extends CommandAbstract{
    public CommandPrintFamalyTree(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Вывести дерево";
    }

    public void execute() {
        consoleUI.printHumanTree();
    }
}
