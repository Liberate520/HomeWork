package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class DeviderCommand extends Command{
    public DeviderCommand(ConsoleUI consoleUI) {
        super("--------------------------------------------------------------------------------------", consoleUI);
    }

    @Override
    public void execute() {
    }
}
