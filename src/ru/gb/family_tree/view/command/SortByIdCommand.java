package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByIdCommand extends Command{
    public SortByIdCommand(ConsoleUI consoleUI) {
        super("Вывести список людей входящих в семейное древо (отсортированный по ID).", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortById();
    }
}
