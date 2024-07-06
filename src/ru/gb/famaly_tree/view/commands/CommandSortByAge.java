package ru.gb.famaly_tree.view.commands;

import ru.gb.famaly_tree.view.ConsoleUI;

public class CommandSortByAge extends CommandAbstract{
    public CommandSortByAge(ConsoleUI consoleUI){
        super(consoleUI);
        discription = "Вывести сортированный по возрасту список людей";
    }

    public void execute() {
        consoleUI.sortByAge();
    }
}
