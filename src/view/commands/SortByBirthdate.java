package view.commands;

import view.ConsoleUI;

public class SortByBirthdate extends Command{

    public SortByBirthdate(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Отсортровать по дате рождения";
    }
    @Override
    public void execute() {
        consoleUI.sortByBirthdate();
    }
}
