package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class PrintNameFamilyTree extends Commands{
    public PrintNameFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть все имена из дерева");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().printNameFamilyTree();
    }
}
