package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class SortByBirthDateCommand extends Command{

    public SortByBirthDateCommand(ConsoleUI cons) {
        super("Отсортировать древо по дате рождения.", cons);
    }

    @Override
    public void execute() {
        getConsole().sortByBirthDate();
    }
}
