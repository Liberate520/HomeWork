package ru.gb.family_tree.view.console_ui.menus.main_menu.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class SaveToFile extends Command {

    public SaveToFile(ConsoleUi consoleUi) {
        super("Сохранить в файл", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().saveFamTreeToFile();
    }
}
