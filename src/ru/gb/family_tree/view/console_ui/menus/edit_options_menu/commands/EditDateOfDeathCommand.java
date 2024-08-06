package ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.enums.LocalDatesTypes;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditDateOfDeathCommand extends Command{
    private int id;
    public EditDateOfDeathCommand(ConsoleUi consoleUi, int id) {
        super("Редактировать дату смерти", consoleUi);
        this.id = id;
    }

    @Override
    public void execute() {
        getConsoleUi().setInfoInCollector((Object) getConsoleUi().inputLocalDate(LocalDatesTypes.DateOfDeath), CollectorItems.DateOfDeath);
    }

}