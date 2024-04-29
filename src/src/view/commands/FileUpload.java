package src.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.view.ConsoleUI;

public class FileUpload extends Command {

    public FileUpload(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить файл";
    }

    @Override
    public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        consoleUI.fileUpload();
    }

}
