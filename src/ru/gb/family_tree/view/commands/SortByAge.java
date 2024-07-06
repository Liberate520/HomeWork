package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать семейное древо по возрасту", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByAge();
    }
}
