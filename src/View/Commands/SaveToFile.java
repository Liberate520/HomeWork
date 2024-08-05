package View.Commands;

import View.ConsoleUI;

import java.io.IOException;

public class SaveToFile extends Command{

    public SaveToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить семейное дерево в файл";
    }

    public void execute() throws IOException {
        consoleUI.saveToFile();
    }
}
