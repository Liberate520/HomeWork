package view.commands;

import view.ConsoleView;

public class ViewAllWODs extends Command {
    public ViewAllWODs(ConsoleView consoleView) {
        super("Просмотреть все WOD", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().viewAllWODs();
    }
}
