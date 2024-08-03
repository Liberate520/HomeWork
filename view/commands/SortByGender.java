package view.commands;

import view.ConsoleUI;

public class SortByGender extends Command {

    public SortByGender(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по гендеру";
    }

    @Override
    public void execute() {
        consoleUI.sortByGender();
    }

}
