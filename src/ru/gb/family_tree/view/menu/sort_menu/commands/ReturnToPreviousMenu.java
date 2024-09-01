package ru.gb.family_tree.view.menu.sort_menu.commands;

import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Command;

public class ReturnToPreviousMenu extends Command {
    public static final String DESCRIPTION = "Вернуться в предыдущее меню";

    public ReturnToPreviousMenu(Console console) {
        super(DESCRIPTION, console);
    }

    public void execute(){
        getConsole().returnToPreviosMenu();
    }
}