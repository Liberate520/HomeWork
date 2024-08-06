package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class SortByGender extends Command {
    public SortByGender(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать по полу";
    }

    public void execute(){
        consoleUI.sortByGender();
    }
}
