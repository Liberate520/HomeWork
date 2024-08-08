package View.Commands;

import View.ConsoleUI;

public class SortByNameCommand extends Command {

    public SortByNameCommand(ConsoleUI consoleUI) {
        super("Отсортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
