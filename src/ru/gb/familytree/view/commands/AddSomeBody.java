package ru.gb.familytree.view.commands;

import ru.gb.familytree.view.ConsoleUI;

public class AddSomeBody extends Command {

    public AddSomeBody(ConsoleUI consoleUI) {
        super("Добавить в дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addSomeBody();
    }
}
