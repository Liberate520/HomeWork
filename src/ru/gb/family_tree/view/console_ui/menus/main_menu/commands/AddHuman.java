package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class AddHuman extends Command {

    public AddHuman(ConsoleUi consoleUi) {
        super("Добавить запись", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().initInputDataAddHuman();
    }
}
