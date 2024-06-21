package ru.gb.family.view.command.start;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandMapMenu extends Command {

    public CommandMapMenu(ConsoleUI consoleUI) {
        super("Показать карту навигационного меню", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().mapMenu();

    }
}
