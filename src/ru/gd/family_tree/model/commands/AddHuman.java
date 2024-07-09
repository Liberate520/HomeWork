package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddHuman extends Commands{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить Human");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addHuman();
    }
}
