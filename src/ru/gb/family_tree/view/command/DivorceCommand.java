package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class DivorceCommand extends Command{
    public DivorceCommand(ConsoleUI consoleUI) {
        super("Развод", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().divorce();
    }
}
