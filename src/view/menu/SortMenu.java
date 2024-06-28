package view.menu;

import view.ConsoleUI;
import view.commands.GetNoSortTree;
import view.commands.SortByBirthDate;
import view.commands.SortByName;


public class SortMenu extends Menu {
    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortTree(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new SortByName(consoleUI));
    }
}