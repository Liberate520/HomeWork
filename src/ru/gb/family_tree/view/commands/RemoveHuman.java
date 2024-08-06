package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class RemoveHuman extends Command {
    public RemoveHuman(ConsoleUI consoleUI) {
        super("Удалить человека.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().removeHuman();
    }
}
