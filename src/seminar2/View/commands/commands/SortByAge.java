package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI) {
        super("сортировка по возрасту", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByAge();
    }
}
