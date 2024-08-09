package ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.info_collector.InfoCollector;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditSurnameCommand extends Command {
    private int id;
    private final CollectorItems editedItem = CollectorItems.Surname;
    public EditSurnameCommand(ConsoleUi consoleUi, int id) {
        super("Редактировать фамилию", consoleUi);
        this.id = id;
    }

    @Override
    public void execute() {
        getConsoleUi().setInfoInCollector((Object) inputNewValue(), editedItem);
    }

    private String inputNewValue(){
        return getConsoleUi().inputParam("новую фамилию");
    }
}
