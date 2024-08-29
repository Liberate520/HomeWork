package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class SetDeathDayCommand extends Command {
    public SetDeathDayCommand(ConsoleUI consoleUI) {
        super("Задать дату смерти человека.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setHumanDeathDay();
    }
}
