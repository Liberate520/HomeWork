package View.Commands.Sorts;

import View.Commands.Command;
import View.ConsoleUi;

public class sortedByName extends Command {
    public sortedByName(ConsoleUi consoleUi) {
        super("Сортировка по имени\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.sortByName();
    }
}
