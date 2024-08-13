package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddHumanCommand extends Command {

    public AddHumanCommand(ConsoleUI consoleUI) {
        super("Добавить человека в семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}


