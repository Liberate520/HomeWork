package view.menu;

import view.ConsoleUI;
import view.command.*;

import java.util.ArrayList;

public class ActionFindMenu extends Menu {

    public ActionFindMenu(ConsoleUI consoleUI) {
        menuName = "Меню дейсвия:";
        commands = new ArrayList<>();
        commands.add(new SetParents(consoleUI));
        commands.add(new Age(consoleUI));
        commands.add(new GetParents(consoleUI));
        commands.add(new GetChildren(consoleUI));
        commands.add(new GetGrandparents(consoleUI));
        commands.add(new GetGrandsons(consoleUI));
        commands.add(new Exit(consoleUI));
    }
}

