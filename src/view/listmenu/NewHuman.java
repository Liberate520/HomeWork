package view.listmenu;

import view.ConsoleUI;

import java.io.IOException;

public class NewHuman extends Command {
    public NewHuman(ConsoleUI consoleUI) {
        super("Создать нового человека", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().createHuman();
    }
}