package ru.gb.family.view.command.editTree;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandAddItemTree extends Command {
    public CommandAddItemTree(ConsoleUI consoleUI) {
        super("Добавить в дерево новый экземпляр", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().addItemTree();
    }
}
