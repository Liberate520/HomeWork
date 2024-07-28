package ru.gb.familytree.view.commands;

import ru.gb.familytree.view.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI consoleUI) {
        super("Сохранить дерево в файл", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().save();
    }
}
