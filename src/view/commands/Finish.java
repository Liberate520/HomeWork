package view.commands;

import view.ConsoleUi;

public class Finish extends Command {

    public Finish(ConsoleUi consoleUi) {
        super("Выход из программы", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().finish();
    }
}
