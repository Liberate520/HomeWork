package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class ExitProgram extends Command {

    public ExitProgram(ConsoleUi consoleUi) {
        super("Выйти из программы", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().exitProgram();
    }
}
