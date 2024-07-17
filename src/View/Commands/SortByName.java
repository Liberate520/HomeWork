package View.Commands;

import View.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super("Сортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SortByName();
    }
}
