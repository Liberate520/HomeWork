package View.Commands;

import View.ConsoleUI;

public class SortByBirthdate extends Command{

    public SortByBirthdate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать семейное дерево по дате рождения";
    }

    public void execute() {
        consoleUI.sortByBirthdate();
    }
}
