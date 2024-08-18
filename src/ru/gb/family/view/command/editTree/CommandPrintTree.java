package ru.gb.family.view.command.editTree;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandPrintTree extends Command {
    public CommandPrintTree(ConsoleUI consoleUI) {
        super("Вывести в консоль все элементы дерева:", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().printTree();
    }
}
