package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddHuman extends Commands{
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить человека в семейное дерево");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addHuman();
    }
}
