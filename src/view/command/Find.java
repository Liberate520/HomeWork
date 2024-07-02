package view.command;

import view.ConsoleUI;

public class Find extends Command {

    public Find(ConsoleUI consoleUI) {
        super("Найти человека ->", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().findHuman();
    }
}
