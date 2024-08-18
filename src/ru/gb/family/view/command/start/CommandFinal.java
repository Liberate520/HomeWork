package ru.gb.family.view.command.start;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandFinal extends Command {
    public CommandFinal( ConsoleUI consoleUI) {
        super("Выход из программы", consoleUI);
    }


    @Override
    public void run() {

        getConsoleUI().finishMenuStart();

    }
}
