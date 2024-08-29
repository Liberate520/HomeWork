package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class setHumanMotherCommand extends Command {
    public setHumanMotherCommand(ConsoleUI consoleUI) {
        super("Задать мать человека.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setHumanMother();
    }
}
