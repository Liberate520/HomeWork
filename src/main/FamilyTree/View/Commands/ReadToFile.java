package FamilyTree.View.Commands;

import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class ReadToFile extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public ReadToFile(ConsoleUI consoleUI) {
        super("загрузить дерево из файла", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().readToFile();

    }
}
