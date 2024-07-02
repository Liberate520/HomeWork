package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

import java.io.IOException;

public class Save extends Command{

    public Save(ConsoleUI consoleUI) {
        super("сохранение дерева", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().save();
    }
}
