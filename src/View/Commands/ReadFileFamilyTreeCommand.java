package View.Commands;

import View.ConsoleUI;

import java.io.IOException;

public class ReadFileFamilyTreeCommand extends Command{

    public ReadFileFamilyTreeCommand(ConsoleUI consoleUI) {
        super("Загрузить дерево из файла", consoleUI);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsoleUI().readFileFamilyTree();
    }
}