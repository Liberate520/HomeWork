package ru.gb.family_tree.view.menu.main_menu.commands;

import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Command;

public class FindHumanById extends Command {
    public static final String DESCRIPTION = "Найти человека по id";

    public FindHumanById(Console console) {
        super(DESCRIPTION, console);
    }

    public void execute(){
        getConsole().findHumanById();
    }
}
