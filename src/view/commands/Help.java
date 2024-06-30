package view.commands;

import view.ConsoleUI;

public class Help extends Command {

    public Help(ConsoleUI consoleUI) {
        super("Вызов справки", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().callingHelp();
    }
}
