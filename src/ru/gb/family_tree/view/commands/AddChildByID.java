package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddChildByID extends Command{

    public AddChildByID(ConsoleUI consoleUI){
        super("Установить ребенка по ID", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChildByID();
    }
}