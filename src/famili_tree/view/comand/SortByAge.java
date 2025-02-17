package view.comand;

import view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать по возрасту";
    }
    public void execute(){
        consoleUI.sortByAge();
    }
}
