package ru.gb.family_tree.view.console_ui.menus.choose_gender.commands;

import ru.gb.family_tree.model.human.enums.Gender;
import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.info_collector.CollectorItems;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class ChooseWoman extends Command {
    public ChooseWoman(ConsoleUi consoleUi) {
        super("Женский", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().setInfoInCollector((Object) Gender.Female, CollectorItems.Gender);
    }
}
