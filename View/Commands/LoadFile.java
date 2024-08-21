package homeWork.View.Commands;

import homeWork.View.ConsoleUI;

public class LoadFile extends Command{
    public LoadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить файл";
    }

    public void execute(){
        consoleUI.loadFromFile();
    }
}