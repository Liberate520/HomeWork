package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class SortBySurname extends Command{

    public SortBySurname(ConsoleUI consoleUI) {
        super("сортировка по фамилии", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortBySurname();
    }
}
