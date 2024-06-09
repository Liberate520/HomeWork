package com.familytree.view.commands;

import com.familytree.view.ConsoleUI;

public class GetHumanListInfo extends Command{

    public GetHumanListInfo(ConsoleUI consoleUI){
        super(consoleUI, "Получить список родственников");
    }

    @Override
    public void execute(){
        getConsoleUI().getHumanListInfo();
    }
}
