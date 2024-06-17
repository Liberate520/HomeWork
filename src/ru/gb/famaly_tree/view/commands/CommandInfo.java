package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandInfo extends CommandAbstract {
    public CommandInfo(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Вывести инофрмацию о человеке";
    }

    public void execute() {
        consoleUI.info();
    }

}
