package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class SortByName extends Commands{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть все имена из дерева отсортированные по имени");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().sortByName();
    }
}