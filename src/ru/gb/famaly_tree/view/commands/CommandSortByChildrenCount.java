package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandSortByChildrenCount extends CommandAbstract{
    public CommandSortByChildrenCount(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Вывести сортированный по количеству детей у родителя список людей";
    }

    public void execute() {
        consoleUI.sortByChildrenCount();
    }
}
