package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandSortByName extends CommandAbstract{
    public CommandSortByName(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Вывести сортированный по имени список людей";
    }

    public void execute() {
        consoleUI.sortByName();
    }
}
