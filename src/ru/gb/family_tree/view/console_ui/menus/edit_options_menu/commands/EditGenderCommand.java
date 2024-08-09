package ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditGenderCommand extends Command {
    private int id;
    public EditGenderCommand(ConsoleUi consoleUi, int id) {
        super("Редактировать пол", consoleUi);
        this.id = id;
    }

    @Override
    public void execute() {
        getConsoleUi().initChooseGenderMenu();
    }

}
