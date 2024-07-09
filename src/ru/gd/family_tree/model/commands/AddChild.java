package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddChild extends Commands {

    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить ребёнка");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addChild();
    }
}

