package view.commands;

import view.ConsoleUI;

public class SortByDeathDate extends Command{
    public SortByDeathDate(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка по дате смерти";
    }

    @Override
    public void execute() {consoleUI.sortByDeathDate();}
}
