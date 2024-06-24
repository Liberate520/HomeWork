package View.Commands;

import View.ConsoleUI;

import java.io.IOException;

public class writeObjectToFile extends Command{
    public writeObjectToFile(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сериализовать древо в файл";
    }


    @Override
    public void execute() throws IOException {
        consoleUI.writeObjectToFile();
    }
}
