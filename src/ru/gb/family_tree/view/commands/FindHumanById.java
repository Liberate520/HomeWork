package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class FindHumanById extends Command {
    public FindHumanById(ConsoleUI consoleUI) {
        super("Найти человека по ID", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().findHumanById();
    }
}
