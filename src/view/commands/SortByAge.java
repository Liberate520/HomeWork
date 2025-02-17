package view.commands;

import view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Сортировка дерево по возросту";
    }

    @Override
    public void execute() {consoleUI.sortByAge();}
}
