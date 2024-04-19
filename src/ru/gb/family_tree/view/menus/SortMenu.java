package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.GetNoSortTree;
import ru.gb.family_tree.view.commands.SortTreeByAge;
import ru.gb.family_tree.view.commands.SortTreeByName;


public class SortMenu extends Menu {
    public SortMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new GetNoSortTree(consoleUI));
        commandList.add(new SortTreeByAge(consoleUI));
        commandList.add(new SortTreeByName(consoleUI));
    }
}


//-------------------------------------------------------
