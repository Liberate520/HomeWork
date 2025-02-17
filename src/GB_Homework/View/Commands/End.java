package GB_Homework.View.Commands;


import GB_Homework.View.ConsoleUI;

public class End extends Commands{

    public End(ConsoleUI consoleUI) {
        super(consoleUI,"Завершить работу");// description устанавливаем тут
    }

    @Override
    void execute() {
        getConsoleUI().end();
    }
}
