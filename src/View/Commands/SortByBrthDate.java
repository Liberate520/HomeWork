package View.Commands;

import View.ConsoleUI;

public class SortByBrthDate extends Command {
    public SortByBrthDate( ConsoleUI consoleUI) {
        super("Сортировать по году рождения", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().SortByAge();
    }
}

