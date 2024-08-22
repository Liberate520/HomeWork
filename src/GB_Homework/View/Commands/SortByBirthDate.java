package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class SortByBirthDate extends Command{

    public SortByBirthDate(ConsoleUI consoleUI) {
        super("Отсортировать по дате рождения", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByBirthDate();
    }

    // Ошибка в сортировке, нужно будет исправить!
}
