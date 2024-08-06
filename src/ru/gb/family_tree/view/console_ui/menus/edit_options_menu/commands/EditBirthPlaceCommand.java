package ru.gb.family_tree.view.console_ui.menus.edit_options_menu.commands;

import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.info_collector.InfoCollector;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class EditBirthPlaceCommand extends Command {
    private int id;
    private final CollectorItems editedItem = CollectorItems.BirthPlace;
    public EditBirthPlaceCommand(ConsoleUi consoleUi, int id) {
        super("Редактировать место рождения", consoleUi);
        this.id = id;
    }

    @Override
    public void execute() {
        getConsoleUi().setInfoInCollector((Object) inputNewValue(), editedItem);
    }

    private String inputNewValue(){
        return getConsoleUi().inputParam("новое место рождения");
    }
}
