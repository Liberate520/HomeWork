package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByAgeCommand extends Command {
    public SortByAgeCommand(ConsoleUI consoleUI) {
        super("Вывести список людей входящих в семейное древо (отсортированный по возрасту).", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}
