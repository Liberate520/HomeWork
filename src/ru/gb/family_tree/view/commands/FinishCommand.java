package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class FinishCommand extends Command {

    public FinishCommand(ConsoleUI consoleUI) {
        super("Выход", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
