package ru.gb.family.view.command.editTree;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandChangeTree extends Command {
    public CommandChangeTree(ConsoleUI consoleUI) {
        super("Редактирование элемента дерева:", consoleUI);
    }


    @Override
    public void run() {
        getConsoleUI().editItemTree();
    }
}
