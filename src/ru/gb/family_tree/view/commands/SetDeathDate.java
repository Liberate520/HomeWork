package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class SetDeathDate extends Command {
    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Обозначить дату смерти";
    }

    @Override
    public void execute() {
        consoleUI.setDeathDate();
    }
}


//---------------------------------------------------