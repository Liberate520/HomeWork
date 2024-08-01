package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по возрасту";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}
