package ru.gb.family_tree.view.commands;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать людей по имени.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
        getConsoleUI().getHumanListInfo();
    }
}
