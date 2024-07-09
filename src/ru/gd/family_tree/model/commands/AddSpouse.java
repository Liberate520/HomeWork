package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddSpouse extends Commands{
    public AddSpouse(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить супруга(супругу) :");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addSpouse();
    }
}


