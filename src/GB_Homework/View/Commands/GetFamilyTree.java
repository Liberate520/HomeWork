package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class GetFamilyTree extends Commands{

    public GetFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть дерево целиком");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().getFamiliTree();
    }
}
