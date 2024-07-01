package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

import java.io.IOException;

public class Load extends Command{

    public Load(ConsoleUI consoleUI) {
        super("загрузка дерева", consoleUI);
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        getConsoleUI().load();
    }
}
