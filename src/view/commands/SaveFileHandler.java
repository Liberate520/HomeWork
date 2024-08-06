package view.commands;

import view.ConsoleUI;

public class SaveFileHandler extends Command {

    public SaveFileHandler(ConsoleUI consoleUI) {
        super("Сохранить древо в файл", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveFileHandler();
    }
}
