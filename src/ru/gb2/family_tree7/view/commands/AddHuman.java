package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить студента";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}