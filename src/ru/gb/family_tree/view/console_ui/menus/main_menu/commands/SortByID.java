package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class SortByID extends Command {

    public SortByID(ConsoleUi consoleUi) {
        super("Сортировать по ID", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortById();
    }
}
