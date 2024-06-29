package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortById extends Command {


    public SortById(ConsoleUI consoleUI) {
        super("Отсортировать семейное древо по ID", consoleUI);
    }

    public void execute() {
        getConsoleUI().sortById();
    }
}
