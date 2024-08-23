package View.Commands;

import View.ConsoleWork;

public class SortByName extends Command {

    public SortByName(ConsoleWork consoleWork) {
        super(consoleWork);
        description = "Сортировака по имени";
    }

    @Override
    public void execute() {
        consoleWork.sortByName();
    }
}