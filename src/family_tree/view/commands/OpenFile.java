package family_tree.view.commands;

import family_tree.view.ConsoleUI;

import java.io.IOException;

public class OpenFile extends Command {

    public OpenFile(ConsoleUI consoleUI) {
        super(consoleUI, "Открыть ранее сохраненный файл");
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsoleUI().readFromFile();

    }
}
