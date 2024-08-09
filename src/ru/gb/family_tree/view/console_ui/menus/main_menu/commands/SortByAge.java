package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class SortByAge extends Command {

    public SortByAge(ConsoleUi consoleUi) {
        super("Сортировать по возрасту", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByAge();
    }
}
