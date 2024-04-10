package view.allcommands;

import view.ConsoleUI;

public class SortByDateOfBirth extends Command{
    public SortByDateOfBirth(ConsoleUI consoleUI) {
        super(consoleUI);
        description="Выполнить сортировку по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByDateOfBirth();
    }
}
