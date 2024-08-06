package ru.gb.family_tree.view.console_ui.menus.load_file.commands;

import ru.gb.family_tree.view.console_ui.ConsoleUi;
import ru.gb.family_tree.view.console_ui.menus.command.Command;

public class LoadFileCommand extends Command {

    public LoadFileCommand(String description, ConsoleUi consoleUi) {
        super(description, consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().loadFamTreeFromFile(getDescription());
    }
}
