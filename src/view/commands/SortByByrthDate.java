package view.commands;

import view.ConsoleUI;

public class SortByByrthDate extends Command{
    public SortByByrthDate(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка по дате рождения";
    }

    @Override
    public void execute() {consoleUI.sortByBirthDate();}
}
