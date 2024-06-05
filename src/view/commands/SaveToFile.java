package view.commands;

import view.ConsoleUI;

import java.io.IOException;

public class SaveToFile extends Command {
    public SaveToFile(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сохранить дерево в файл";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {consoleUI.saveToFile();}
}
