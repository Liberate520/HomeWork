package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class SortByBirthDate extends Command{

    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Отсортировать членов семьи по дате рождения", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDate();
    }
}