package view.commands.sort;

import view.ConsoleUI;
import view.commands.Command;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по именам", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByName();
    }
}