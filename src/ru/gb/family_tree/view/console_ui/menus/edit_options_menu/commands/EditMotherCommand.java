package ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditMotherCommand extends Command {
    private int id;
    public EditMotherCommand(ConsoleUi consoleUi, int id) {
        super("Редактировать мать", consoleUi);
        this.id = id;
    }

    @Override
    public void execute() {
        getConsoleUi().initChooseMotherMenu();
    }

}