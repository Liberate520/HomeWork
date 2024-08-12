package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class AddChild extends Commands {

    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить данные о ребёнке");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addChild();
    }
}

