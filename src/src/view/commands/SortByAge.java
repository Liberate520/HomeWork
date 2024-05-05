package src.view.commands;

import src.view.ConsoleUI;

public class SortByAge extends Command {

    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по возрасту";
    }

    @Override
    public void execute() {
        consoleUI.sortByAge();
    }

}
