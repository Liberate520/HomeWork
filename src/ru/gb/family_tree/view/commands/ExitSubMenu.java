package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class ExitSubMenu extends Command {

    public ExitSubMenu(ConsoleUI consoleUI) {
        super("Выйти в основное меню", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().exitMenu();
    }
}
