package ru.gb.family_tree.view.menu.sort_menu.commands;

import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Command;

public class SortByBirthDate extends Command {
    public static final String DESCRIPTION = "Отсортирвать по дате рождения";

    public SortByBirthDate(Console console) {
        super(DESCRIPTION, console);
    }

    public void execute(){
        getConsole().sortByBirthDate();
    }
}