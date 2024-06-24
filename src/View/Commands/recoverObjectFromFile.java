package View.Commands;

import View.ConsoleUI;

import java.io.IOException;

public class recoverObjectFromFile extends Command{
    public recoverObjectFromFile(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Десериализовать древо из файла";
    }


    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.recoverObjectFromFile();
    }
}
