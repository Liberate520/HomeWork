package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddParentsCommand extends Command {

    public AddParentsCommand(ConsoleUI consoleUI) {
        super("Добавить родителей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParents();
    }
}