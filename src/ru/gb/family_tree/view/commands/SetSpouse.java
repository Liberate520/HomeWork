package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class SetSpouse extends Command {

    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить супруга(у)";
    }

    @Override
    public void execute() {
        consoleUI.setSpouse();
    }
}


//---------------------------------------------------