package view.commands;

import view.ConsoleUI;

public class GetGrandparents extends Command {

    public GetGrandparents(ConsoleUI consoleUI) {
        super("Показать бабушек и дедушек", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getGrandparents();
    }
}
