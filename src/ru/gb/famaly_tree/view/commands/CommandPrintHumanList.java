package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandPrintHumanList extends CommandAbstract{
    public CommandPrintHumanList(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Вывод списка людей в семейном древе";
    }

    public void execute() {
        consoleUI.printHumanList();
    }
}
