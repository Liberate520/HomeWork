package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddParent extends Command {

    public AddParent(ConsoleUI consoleUI) {
        super("Добавить отца/мать", consoleUI);        
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}
