package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class SortByData extends Commands{
    public SortByData(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть все имена из дерева отсортированные по дате");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().sortByData();
    }
}
