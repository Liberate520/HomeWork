package view.command;

import view.ConsoleUI;

public class SortName extends Command {

    public SortName(ConsoleUI consoleUI) {
        super("Сортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortName();
    }
}

