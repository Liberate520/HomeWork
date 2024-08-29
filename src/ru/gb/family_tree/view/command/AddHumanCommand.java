package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class AddHumanCommand extends Command {
    public AddHumanCommand(ConsoleUI consoleUI) {
        super("Добавить нового человека.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}
