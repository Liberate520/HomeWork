package view.commands;

import view.ConsoleUi;

public class SortById extends Command{

    public SortById(ConsoleUi consoleUi) {
        super("Отсортировать по Id", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().sortById();
    }
}
