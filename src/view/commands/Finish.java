package view.commands;

import view.ConsoleUI;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super("Завершить работу", consoleUI);
    }

    public void execute() {
        getConsoleUI().finish();
    }
}