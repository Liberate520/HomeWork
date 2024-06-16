package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(@SuppressWarnings("rawtypes") ConsoleUI consoleUI) {
        super("Отсортировать список по возрасту", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortByAge();
    }
}
