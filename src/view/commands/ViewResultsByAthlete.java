package view.commands;

import view.ConsoleView;

public class ViewResultsByAthlete extends Command {
    public ViewResultsByAthlete(ConsoleView consoleView) {
        super("Просмотреть результаты по атлету", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().viewResultsByAthlete();
    }
}
