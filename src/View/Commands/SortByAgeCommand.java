package View.Commands;

import View.ConsoleUI;

public class SortByAgeCommand extends Command{

    public SortByAgeCommand(ConsoleUI consoleUI) {
        super("Отсортировать по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}
