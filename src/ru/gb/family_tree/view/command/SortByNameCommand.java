package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByNameCommand extends Command{
    public SortByNameCommand(ConsoleUI consoleUI) {
        super("Вывести список людей входящих в семейное древо (отсортированный по имени).", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
