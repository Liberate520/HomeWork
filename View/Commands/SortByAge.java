package View.Commands;

import View.ConsoleWork;

public class SortByAge extends Command {

    public SortByAge(ConsoleWork consoleWork) {
        super(consoleWork);
        description = "Сортировка по дате рождения";
    }

    @Override
    public void execute() {
        consoleWork.sortByAge();
    }
}

