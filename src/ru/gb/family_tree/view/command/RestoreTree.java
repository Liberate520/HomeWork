package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class RestoreTree extends Command {
    public RestoreTree(ConsoleUI consoleUI) {
        super("Восстановить семейное древо из файла.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().restoreTree();
    }
}
