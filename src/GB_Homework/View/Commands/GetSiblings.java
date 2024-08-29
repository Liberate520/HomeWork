package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class GetSiblings extends Commands{

    public GetSiblings(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть список братьев и сестер");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().getSiblings();
    }
}
