package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class SortByBirthDate extends Command{

    public SortByBirthDate(ConsoleUI consoleUI){
        super(consoleUI, "Отсортировать по дате рождения");
    }

    @Override
    public void execute(){
        getConsoleUI().sortByBirthDate();
    }
}
