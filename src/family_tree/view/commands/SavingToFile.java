package family_tree.view.commands;

import family_tree.view.ConsoleUI;

import java.io.IOException;

public class SavingToFile extends Command{
    public SavingToFile(ConsoleUI consoleUI) {
        super(consoleUI, "Cохранить в файл .txt");
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().saveToFile();

    }
}
