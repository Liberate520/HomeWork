package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class SetMother extends Command {
    public SetMother(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить мать";
    }

    @Override
    public void execute() {
        consoleUI.setMother();
    }
}


//---------------------------------------------------
