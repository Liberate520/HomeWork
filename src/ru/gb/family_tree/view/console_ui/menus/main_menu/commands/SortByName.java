package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class SortByName extends Command {

    public SortByName(ConsoleUi consoleUi) {
        super("Сортировать по имени", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByName();
    }
}
