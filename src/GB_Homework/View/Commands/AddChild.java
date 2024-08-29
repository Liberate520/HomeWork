package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class AddChild extends Commands {

    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI,"Добавить данные о ребёнке");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().addChild();
    }
}
