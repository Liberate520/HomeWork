package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class SortByBirthDate extends Command {

    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Сортировать записи по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByBirthDate();
    }
}