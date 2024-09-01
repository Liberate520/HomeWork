package ru.gb.family_tree.view.menu.main_menu;

import ru.gb.family_tree.view.Console;
import ru.gb.family_tree.view.menu.Menu;
import ru.gb.family_tree.view.menu.Command;
import ru.gb.family_tree.view.menu.main_menu.commands.AddHuman;
import ru.gb.family_tree.view.menu.main_menu.commands.FindHumanById;
import ru.gb.family_tree.view.menu.main_menu.commands.GetHumanList;
import ru.gb.family_tree.view.menu.main_menu.commands.SortBy;

import java.util.List;

public class MainMenu extends Menu {
    public MainMenu(Console console) {
        super(console);
    }

    @Override
    protected void setCommands() {
        List<Command> commands = getCommands();
        commands.add(new AddHuman(getConsole()));
        commands.add(new FindHumanById(getConsole()));
        commands.add(new GetHumanList(getConsole()));
        commands.add(new SortBy(getConsole()));
    }
}
