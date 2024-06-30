package view.commands;

import view.ConsoleUI;

public class GetGrandsons extends Command {

    public GetGrandsons(ConsoleUI consoleUI) {
        super("Показать внуков", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getGrandsons();
    }
}