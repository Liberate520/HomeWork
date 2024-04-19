package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;


public class SortTreeByName extends Command {
    public SortTreeByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Вывести список членов в семьи в порядке сортировки по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortTreeByName();
    }
}


//-----------------------------------------------------