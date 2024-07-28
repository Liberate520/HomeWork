package view.commands.sort;

import view.ConsoleUI;
import view.commands.Command;

public class SortByChildrenQuantity extends Command {
    public SortByChildrenQuantity(ConsoleUI consoleUI) {
        super("Отсортировать людей по кол.-ву детей в семье", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByChildrenQuantity();
    }
}
