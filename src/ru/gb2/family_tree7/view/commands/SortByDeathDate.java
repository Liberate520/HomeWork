package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class SortByDeathDate extends Command {
    public SortByDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Отсортировать по дате смерти";
    }

    @Override
    public void execute() {
        consoleUI.sortByDeathDate(); // Метод для сортировки по дате смерти
    }
}
