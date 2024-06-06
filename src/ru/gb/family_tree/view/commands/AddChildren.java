package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddChildren extends Command{

    public AddChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка";
    }

    public void execute(){
        consoleUI.addChildren();
    }
}
