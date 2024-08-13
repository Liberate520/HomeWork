package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SortBySurname extends Command{
    public SortBySurname(ConsoleUI consoleUI){
        super("sort by surname", "Сортировка по фамилии", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortBySurname();
    }
}
