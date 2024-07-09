package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

public class GetSiblings extends Commands{
    public GetSiblings(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть список братьев и сестер");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().getSiblings();
    }
}


