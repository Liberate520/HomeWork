package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class SetFather extends Command {
    public SetFather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить отца";
    }

    @Override
    public void execute() {
        consoleUI.setFather();
    }
}


//---------------------------------------------------