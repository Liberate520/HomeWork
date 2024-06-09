package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI){
        super(consoleUI, "Закончить работу");
    }

    @Override
    public void execute(){
        getConsoleUI().finish();
    }
}
