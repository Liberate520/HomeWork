package view.commands;

import view.ConsoleUI;

public class SortByDayOfBirth extends Command {
    public SortByDayOfBirth(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort by Day of Birth";
    }

    public void execute(){
        consoleUI.sortByDayOfBirth();
    }
}