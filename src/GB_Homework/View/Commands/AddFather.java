package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class AddFather extends Commands{

    public AddFather(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить данные об отце");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addFather();
    }
}
