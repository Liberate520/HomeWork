package View.Commands;

import View.ConsoleUI;

import java.io.IOException;

public class LoadFromFile extends Command{

    public LoadFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить семейное дерево из файла";
    }

    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.loadFromFile();
    }
}
