package view.comand;

import view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать по имени";
    }
    public void execute(){
        consoleUI.sortByName();
    }
}