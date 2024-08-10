package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddSpouse extends Commands{
    public AddSpouse(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить данные о супруге");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addSpouse();
    }
}


