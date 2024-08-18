package ru.gb.family.view.command.editItemTree;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandFinishEditItemTree extends Command {
    public CommandFinishEditItemTree(ConsoleUI consoleUI) {
        super("Выход из программы", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().finishMenuEditTree();
    }
}