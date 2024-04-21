package FamilyTree.View.Commands;



import FamilyTree.View.ConsoleUI;

import java.io.IOException;

public class SaveToFile extends Commands{
    private String description;
    private ConsoleUI consoleUI;

    public SaveToFile(ConsoleUI consoleUI) {
        super("выгрузить дерево в файл", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        super.getConsoleUI().saveToFile();
    }
}
