package ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditApplyChanges extends Command {
    private int id;
    public EditApplyChanges(ConsoleUi consoleUi, int id) {
        super("Применить изменения", consoleUi);
        this.id = id;
    }

    @Override
    public void execute() {
        getConsoleUi().editHuman(id);
    }

}
