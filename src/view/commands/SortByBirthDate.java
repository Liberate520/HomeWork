package view.commands;

import view.ConsoleUI;

public class SortByBirthDate extends Command {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Сортировка семейного древа по дате рождения", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByBirthDate();
    }
}