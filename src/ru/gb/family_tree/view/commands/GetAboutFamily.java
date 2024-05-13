package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class GetAboutFamily extends Command {
    public GetAboutFamily(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список всех членов семьи из древа \uD83D\uDCDD";
    }

    @Override
    public void execute() {
        consoleUI.getAboutFamily();
    }
}


//---------------------------------------------------------
