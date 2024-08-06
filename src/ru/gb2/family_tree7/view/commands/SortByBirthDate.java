package ru.gb2.family_tree7.view.commands;

import ru.gb2.family_tree7.view.ConsoleUI;

public class SortByBirthDate extends ru.gb2.family_tree7.view.commands.Command {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        this.description = "Отсортировать по дате рождения";
    }

    @Override
    public void execute() {
        consoleUI.sortByBirthDate(); // Метод для сортировки по дате рождения
    }
}
