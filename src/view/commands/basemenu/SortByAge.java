package view.commands.basemenu;

import view.ConsoleUi;
import view.commands.Command;

public class SortByAge extends Command {

    public SortByAge(ConsoleUi consoleUi) {
        super("Отсортировать по возрасту", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByAge();
    }
}