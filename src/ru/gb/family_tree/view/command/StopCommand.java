package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class StopCommand extends Command{
    public StopCommand(ConsoleUI consoleUI) {
        super("Выход.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().stop();
    }
}
