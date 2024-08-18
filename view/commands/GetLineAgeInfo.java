package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class GetLineAgeInfo extends Command{

    public GetLineAgeInfo(ConsoleUI cons) {
        super("Показать родословное древо.",cons);
    }

    @Override
    public void execute() {
        getConsole().GetLineAgeInfo();
    }
}
