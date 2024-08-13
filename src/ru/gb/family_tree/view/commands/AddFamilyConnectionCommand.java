package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddFamilyConnectionCommand extends Command {

    public AddFamilyConnectionCommand(ConsoleUI consoleUI) {
        super("Семейные связи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().FamConnectMenuShow();
    }
}