package GB_Homework.View.Commands;

import GB_Homework.View.ConsoleUI;

import java.io.IOException;

public class Read extends Commands{
    public Read(ConsoleUI consoleUI) {
        super(consoleUI,"Загрузить древо из файла");// description устанавливаем тут
    }

    @Override
    void execute() {
        try {
            getConsoleUI().readFamilyTree();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
