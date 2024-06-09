package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI){
        super(consoleUI, "Отсортировать по имени");
    }

    @Override
    public void execute(){
        getConsoleUI().sortByName();
    }
}
