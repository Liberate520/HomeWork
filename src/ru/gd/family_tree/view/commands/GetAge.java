package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class GetAge extends Commands {
    public GetAge(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть возраст");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().getAge();
    }
}


