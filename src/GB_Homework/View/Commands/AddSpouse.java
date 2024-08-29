package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class AddSpouse extends Commands{

    public AddSpouse(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить данные о супруге");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addSpouse();
    }
}