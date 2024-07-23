package view.commands;

import view.ConsoleView;

public class AddWOD extends Command {
    public AddWOD(ConsoleView consoleView) {
        super("Добавить WOD", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addWOD();
    }
}
