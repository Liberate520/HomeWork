package ru.gb.family_tree.view.menu.sort_menu;

import ru.gb.family_tree.view.menu.Command;
import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Menu;
import ru.gb.family_tree.view.menu.sort_menu.commands.SortByBirthDate;
import ru.gb.family_tree.view.menu.sort_menu.commands.SortByName;

import java.util.List;

public class SortMenu extends Menu {
    public SortMenu(Console console) {
        super(console);
    }

    @Override
    protected void setCommands() {
        List<Command> commands = getCommands();
        commands.add(new SortByName(getConsole()));
        commands.add(new SortByBirthDate(getConsole()));
    }
}