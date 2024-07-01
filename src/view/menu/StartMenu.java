package view.menu;

import view.ConsoleUI;
import view.command.*;

import java.util.ArrayList;

public class StartMenu extends Menu {

    public StartMenu(ConsoleUI consoleUI) {
        menuName = "Главное меню:";
        commands = new ArrayList<>();
        commands.add(new Load(consoleUI));
        commands.add(new Save(consoleUI));
        commands.add(new AddHuman(consoleUI));
        commands.add(new Find(consoleUI));
        commands.add(new SortTree(consoleUI));
        commands.add(new Print(consoleUI));
        commands.add(new Exit(consoleUI));
    }
}
