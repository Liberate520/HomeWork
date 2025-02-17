package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

public class GetAge extends Commands {

    public GetAge(ConsoleUI consoleUI) {
        super(consoleUI,"Вернуть возраст");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().getAge();
    }
}
