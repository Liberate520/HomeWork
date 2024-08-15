package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class LoadTreeCommand extends Command{
    public LoadTreeCommand(ConsoleUI cons) {
        super("Загрузить древо", cons);
    }

    @Override
    public void execute() {
        getConsole().loadTree();
    }
}
