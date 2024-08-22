package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI) {
        super("Отсортировать по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }

    // Ошибка в сортировке, нужно будет исправить!
}