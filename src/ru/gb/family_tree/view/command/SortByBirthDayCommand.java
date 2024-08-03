package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByBirthDayCommand extends Command {
    public SortByBirthDayCommand(ConsoleUI consoleUI) {
        super("Вывести список людей входящих в семейное древо (отсортированный по дате рождения).", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDay();
    }
}
