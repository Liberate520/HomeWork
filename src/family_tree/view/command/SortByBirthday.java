package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class SortByBirthday extends Command {

    public SortByBirthday(ConsoleUI consoleUI){
        super("Сортировка по дате рождения", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().sortByBirthday();
    }
}
