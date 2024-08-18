package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class AddHumanCommand extends Command{

    public AddHumanCommand(ConsoleUI cons) {
        super("Добавить человека в древо", cons);
    }

    @Override
    public void execute() {
        getConsole().addHuman();

    }
}
