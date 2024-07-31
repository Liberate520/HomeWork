package view.commands.sort;

import view.ConsoleUI;
import view.commands.Command;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("Отсортировать людей по дате рождения", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortByAge();
    }
}
