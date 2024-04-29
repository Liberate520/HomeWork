package src.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import src.view.ConsoleUI;

public class SavingToFile extends Command {

    public SavingToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить файл";
    }

    @Override
    public void execute() throws FileNotFoundException, IOException {
        consoleUI.savingToFile();
    }

}
