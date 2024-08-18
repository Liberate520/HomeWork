package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class SortTreeByNameCommand extends Command{

    public SortTreeByNameCommand(ConsoleUI cons) {
        super("Отсортировать древо по именам.", cons);
    }

    @Override
    public void execute() {
        getConsole().sortTreeByName();
    }
}
