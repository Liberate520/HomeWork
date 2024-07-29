package ru.gb.familytree.view.commands;

import ru.gb.familytree.view.ConsoleUI;

public class Load extends Command {

    public Load(ConsoleUI consoleUI) {
        super("Загрузить дерево из файла", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().load();
    }
}
