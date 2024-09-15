package view.commands;

import view.ConsoleUi;

public class SortByAge extends Command{

    public SortByAge(ConsoleUi consoleUi) {
        super("Отсортировать по возрасту", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortByAge();
    }
}
