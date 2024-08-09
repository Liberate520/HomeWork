package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class LoadFromFile extends Command {

    public LoadFromFile(ConsoleUi consoleUi) {
        super("Загрузить из файла", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().loadFamMenu();
    }
}
