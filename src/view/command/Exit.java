package view.command;

import view.ConsoleUI;

public class Exit extends Command {

    public Exit(ConsoleUI consoleUI) {
        super("Выйти из меню", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().goOut();
    }
}

