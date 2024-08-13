package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SortByID extends Command{
    public SortByID(ConsoleUI consoleUI){
        super("sort by ID", "Сортировка по ID существа", consoleUI);
    }

    @Override
    public void execute() {
       super.getConsoleUI().sortByID();
    }
}
