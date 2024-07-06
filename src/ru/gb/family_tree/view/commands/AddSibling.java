package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddSibling extends Command {

    public AddSibling(ConsoleUI consoleUI) {
        super("Добавить брата или сестру", consoleUI);        
    }

    @Override
    public void execute() {
        getConsoleUI().addSibling();
    }
}
