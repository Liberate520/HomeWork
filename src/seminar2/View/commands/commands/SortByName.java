package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI) {
        super("сортировка по имени", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByName();
    }
}
