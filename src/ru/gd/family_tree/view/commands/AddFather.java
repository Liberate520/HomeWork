package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddFather extends Commands{
    public AddFather(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить отца :");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addFather();
    }
}


