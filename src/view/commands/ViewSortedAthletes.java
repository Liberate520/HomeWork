package view.commands;

import view.ConsoleView;

public class ViewSortedAthletes extends Command {
    public ViewSortedAthletes(ConsoleView consoleView) {
        super("Просмотреть отсортированных атлетов", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().viewSortedAthletes();
    }
}
