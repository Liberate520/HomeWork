package view.commands;

import view.ConsoleView;

public class Finish extends Command {
    public Finish(ConsoleView consoleView) {
        super("Завершение работы", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().finish();
    }
}
