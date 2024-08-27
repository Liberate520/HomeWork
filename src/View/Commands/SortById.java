package View.Commands;

import View.ConsoleUI;

import java.io.IOException;

public class SortById extends Command{
    public SortById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать семейное дерево по Id";
    }

    public void execute() {
        consoleUI.sortById();
    }
}
