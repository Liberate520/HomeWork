package homeWork.View.Commands;

import homeWork.View.ConsoleUI;

public class SaveFile extends Command{
    public SaveFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить файл";
    }

    public void execute(){
        consoleUI.saveToFile();
    }
}