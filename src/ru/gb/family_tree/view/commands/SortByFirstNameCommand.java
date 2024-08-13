package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByFirstNameCommand extends Command {

    public SortByFirstNameCommand(ConsoleUI consoleUI) {
        super("Сортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByFirstName();
    }
}
