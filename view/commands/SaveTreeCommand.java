package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class SaveTreeCommand extends Command{

    public SaveTreeCommand(ConsoleUI cons) {
        super("Сохранить древо", cons);
    }

    @Override
    public void execute() {
        getConsole().saveTree();
    }
}
