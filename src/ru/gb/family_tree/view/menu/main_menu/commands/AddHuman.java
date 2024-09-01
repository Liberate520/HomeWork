package ru.gb.family_tree.view.menu.main_menu.commands;

import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Command;

public class AddHuman extends Command {
    public static final String DESCRIPTION = "Добавить нового человека";

    public AddHuman(Console console) {
        super(DESCRIPTION, console);
    }

    public void execute(){
        getConsole().addHuman();
    }
}
