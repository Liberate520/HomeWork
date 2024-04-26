package view.commands;

import view.ConsoleUI;

public class AddDivorce extends Command {
    public AddDivorce(ConsoleUI consoleUI) {
        super("Расторжение брака", consoleUI);
    }

    public void execute() {
        getConsoleUI().divorce();
    }
}