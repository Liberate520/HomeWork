package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandAddCouple extends CommandAbstract{
    public CommandAddCouple(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Добавить пару";
    }

    public void execute() {
        consoleUI.addCouple();
    }
}
