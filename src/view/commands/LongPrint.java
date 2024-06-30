package view.commands;

import view.ConsoleUI;

public class LongPrint extends Command {

    public LongPrint(ConsoleUI consoleUI) {
        super("Полная печать", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().longPrint();
    }
}
