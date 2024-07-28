package view.commands;

import view.ConsoleUI;

public class SortById extends Command {
    public SortById(ConsoleUI consoleUI) {
        super("Отсортировать по ID", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortById();
    }
}