package view.commands.basemenu;

import view.ConsoleUi;
import view.commands.Command;

public class SortByName extends Command {

    public SortByName(ConsoleUi consoleUi) {
        super("Отсортировать по имени", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByName();
    }
}