package View.Commands.Sorts;

import View.Commands.Command;
import View.ConsoleUi;

public class sortByBirthday extends Command {
    public sortByBirthday(ConsoleUi consoleUi) {
        super("Сортировка по дате рождения\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.sortByBirthday();
    }
}
