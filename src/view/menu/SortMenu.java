package view.menu;

import view.ConsoleUI;
import view.command.Exit;
import view.command.SortAge;
import view.command.SortName;
import view.command.SortNumberChildren;

import java.util.ArrayList;

public class SortMenu extends Menu {

    public SortMenu(ConsoleUI consoleUI) {
        menuName = "Меню сортировки:";
        commands = new ArrayList<>();
        commands.add(new SortName(consoleUI));
        commands.add(new SortAge(consoleUI));
        commands.add(new SortNumberChildren(consoleUI));
        commands.add(new Exit(consoleUI));
    }
}
