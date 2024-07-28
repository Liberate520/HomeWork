package view.commands;

import view.ConsoleUI;

public class SortByGender extends Commands {

    public SortByGender(ConsoleUI consoleUI) {
        super("Отсортировать родственников по гендерному признаку.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByGender();
    }
}
