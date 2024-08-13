package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SortByChildren extends Command{

    public SortByChildren(ConsoleUI consoleUI){
        super("sort by children", "Сортировка по количеству детей", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByChildren();
    }
}
