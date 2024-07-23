package view.commands;

import view.ConsoleView;

public class ViewResultsByWOD extends Command {
    public ViewResultsByWOD(ConsoleView consoleView) {
        super("Просмотреть результаты по WOD", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().viewResultsByWOD();
    }
}
