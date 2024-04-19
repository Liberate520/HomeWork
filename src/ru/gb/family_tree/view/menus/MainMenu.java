package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;

import ru.gb.family_tree.view.commands.*;


public class MainMenu extends Menu {
    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetAboutFamily(consoleUI));
        commandList.add(new AddMember(consoleUI));
        commandList.add(new SetDeathDate(consoleUI));
        commandList.add(new SetMother(consoleUI));
        commandList.add(new SetFather(consoleUI));
        commandList.add(new Read(consoleUI));
        commandList.add(new Write(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}


//-------------------------------------------------------
