package view.commands;

import view.ConsoleUI;

public class SortAge extends Command {

    public SortAge(ConsoleUI consoleUI) {
        super("Сортировать по возрасту", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortAge();
    }
}
