package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать людей по дате рождения", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByAge();
    }
}
