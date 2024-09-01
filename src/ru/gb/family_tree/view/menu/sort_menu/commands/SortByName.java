package ru.gb.family_tree.view.menu.sort_menu.commands;

import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Command;

public class SortByName extends Command {
    public static final String DESCRIPTION = "Отсортировать по имени";

    public SortByName(Console console) {
        super(DESCRIPTION, console);
    }

    public void execute(){
        getConsole().sortByName();
    }
}
