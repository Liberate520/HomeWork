package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("Сортировка семейного древа по возрасту", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByAge();
    }
}