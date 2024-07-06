package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandCreateHuman extends CommandAbstract {
    public CommandCreateHuman(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Добавить человека";
    }

    public void execute() {
        consoleUI.addHuman();
    }
}
