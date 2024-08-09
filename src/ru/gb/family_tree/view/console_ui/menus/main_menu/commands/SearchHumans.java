package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class SearchHumans extends Command {
    public SearchHumans(ConsoleUi consoleUi) {
        super("Найти человека", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().initSearchHumansMenu();
    }
}
