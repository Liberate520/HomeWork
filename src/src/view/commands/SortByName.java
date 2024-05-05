package src.view.commands;

import src.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по Имени";

    }

    @Override
    public void execute() {
        presenter.sortByName();
    }
}