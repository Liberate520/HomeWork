package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class ReadFromFile extends Command {
    public ReadFromFile(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Прочитать дерево из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {consoleUI.readFromFile();}
}
