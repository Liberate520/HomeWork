package view.commands.sort;

import view.ConsoleUI;
import view.commands.Command;

public class SortById extends Command {
    public SortById(ConsoleUI consoleUI) {
        super("Отсортировать по ID", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().sortById();
    }
}