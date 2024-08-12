package view.commands;

import view.ConsoleUI;

public class DisplayFileHandler extends Command {

    public DisplayFileHandler(ConsoleUI consoleUI) {
        super("Восстановить сохраненный файл древа", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().displayFileHandler();
    }
}
