package view.commands;

import view.ConsoleView;

public class AddResult extends Command {
    public AddResult(ConsoleView consoleView) {
        super("Добавить результат", consoleView);
    }

    @Override
    public void execute() {
        getConsoleView().addResult();
    }
}
