package view.commands;

import view.ConsoleUI;

public class SortByName extends Command{

    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сортировать древо по алфавиту по именам";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}
