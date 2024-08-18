package ru.gb.family.view.command.start;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandDelTree extends Command {
    public CommandDelTree(ConsoleUI consoleUI) {
        super("Удалить ранее созданое", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().delTree();
    }
}
