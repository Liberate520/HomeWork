package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class AddHuman extends Commands{

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить человека в семейное дерево");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addHuman();
    }
}
