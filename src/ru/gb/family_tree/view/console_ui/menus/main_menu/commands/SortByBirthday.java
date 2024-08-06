package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class SortByBirthday extends Command {

    public SortByBirthday(ConsoleUi consoleUi) {
        super("Сортировать по дате рождения", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByBirthday();
    }
}
