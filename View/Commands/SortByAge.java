package homeWork.View.Commands;

import homeWork.View.ConsoleUI;

public class SortByAge extends Command{

    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировка по возрасту";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}