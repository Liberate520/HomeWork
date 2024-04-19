package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class SetParent extends Command {

    public SetParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя";
    }

    @Override
    public void execute() {
        consoleUI.setParent();
    }
}


//---------------------------------------------------