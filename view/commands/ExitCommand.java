package com.oop.homeWorkOOP.view.commands;

import com.oop.homeWorkOOP.view.ConsoleUI;

public class ExitCommand extends Command{
    public ExitCommand(ConsoleUI cons) {
        super("Выход.", cons);
    }

    @Override
    public void execute() {
        getConsole().exit();
    }
}
