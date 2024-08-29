package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class setHumanFatherCommand extends Command {
    public setHumanFatherCommand(ConsoleUI consoleUI) {
        super("Задать отца человека.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setHumanFather();
    }
}
