package View.Commands;

import View.ConsoleUI;

public class SortById extends Command {
    public SortById(ConsoleUI consoleUI) {
        super("Сортировать по id", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SortById();
    }
}

