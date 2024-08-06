package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditHuman extends Command {

    public EditHuman(ConsoleUi consoleUi) {
        super("Редактировать запись", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().initEditMenu();
    }
}
