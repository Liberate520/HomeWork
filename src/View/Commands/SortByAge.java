package View.Commands;

import View.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать семейное дерево по возрасту";
    }

    public void execute() {
        consoleUI.sortByAge();
    }
}
