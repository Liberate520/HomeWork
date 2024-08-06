package ru.gb.family_tree.view.console_ui.menus.edit_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditMenuCommand extends Command {
    private int id;

    public EditMenuCommand(String description, ConsoleUi consoleUi, int id) {
        super(description, consoleUi);
        this.id = id;
    }

    @Override
    public void execute() {
        getConsoleUi().initEditOptions(id);
    }
}
