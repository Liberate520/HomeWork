package view.commands;

import view.ConsoleUI;

public class AddWedding extends Command {
    public AddWedding(ConsoleUI consoleUI) {
        super("Регистрация брака", consoleUI);
    }

    public void execute() {
        getConsoleUI().wedding();
    }
}