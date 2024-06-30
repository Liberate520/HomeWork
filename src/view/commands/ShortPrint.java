package view.commands;

import view.ConsoleUI;

public class ShortPrint extends Command {

    public ShortPrint(ConsoleUI consoleUI) {
        super("Краткая печать", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().shortPrint();
    }
}
