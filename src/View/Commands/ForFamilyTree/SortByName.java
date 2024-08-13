package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI){
        super("sort by name", "Сортировка семейного древа по имени", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().sortByName();
    }
}
