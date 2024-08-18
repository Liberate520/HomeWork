package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class GetHumanByName extends  Command{
    public GetHumanByName(ConsoleUI cons) {
        super("Найти человека по имени.", cons);
    }

    @Override
    public void execute() {
        getConsole().getHumanByName();
    }
}
