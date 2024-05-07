package view.Commands;

import view.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI){
        super("Отсортировать по имени", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
