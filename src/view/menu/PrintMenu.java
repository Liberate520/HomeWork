package view.menu;

import view.ConsoleUI;
import view.commands.*;

import java.util.ArrayList;

public class PrintMenu extends Menu {

    public PrintMenu(ConsoleUI consoleUI) {
        menuName = "Меню сортировки:";
        commands = new ArrayList<>();
        commands.add(new Help(consoleUI));
        commands.add(new ShortPrint(consoleUI));
        commands.add(new LongPrint(consoleUI));
        commands.add(new Exit(consoleUI));
    }
}
