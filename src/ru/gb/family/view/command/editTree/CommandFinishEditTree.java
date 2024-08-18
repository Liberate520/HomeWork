package ru.gb.family.view.command.editTree;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandFinishEditTree extends Command {
    public CommandFinishEditTree( ConsoleUI consoleUI) {
        super("Выход в главное меню", consoleUI);
    }


    @Override
    public void run() {
        getConsoleUI().finishMenuEditTree();
    }
}
