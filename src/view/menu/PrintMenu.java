package view.menu;

import view.ConsoleUI;
import view.command.Exit;
import view.command.LongPrint;
import view.command.ShortPrint;

import java.util.ArrayList;

public class PrintMenu extends Menu {

    public PrintMenu(ConsoleUI consoleUI) {
        menuName = "Меню сортировки:";
        commands = new ArrayList<>();
        commands.add(new ShortPrint(consoleUI));
        commands.add(new LongPrint(consoleUI));
        commands.add(new Exit(consoleUI));
    }
}
