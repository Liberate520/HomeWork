package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class AddMother extends Commands{

    public AddMother(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить данные о матери");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addMother();
    }
}
