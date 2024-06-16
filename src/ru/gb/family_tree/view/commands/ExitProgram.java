package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class ExitProgram extends Command {

    public ExitProgram(@SuppressWarnings("rawtypes") ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
