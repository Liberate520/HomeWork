package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class ShowFamilyTree extends Command {

    public ShowFamilyTree(ConsoleUi consoleUi) {
        super("Показать фамильное древо", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().getFamilyTreeInfo();
    }
}
