package ru.gb.family_tree.view.menu.main_menu.commands;

import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Command;

public class GetHumanList extends Command {
    public static final String DESCRIPTION = "Получить список людей";

    public GetHumanList(Console console) {
        super(DESCRIPTION, console);
    }

    public void execute(){
        getConsole().getHumanList();
    }
}
