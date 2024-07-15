package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class End extends Commands{
    public End(ConsoleUI consoleUI) {
        super(consoleUI,"Завершить работу");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().end();
    }
}

