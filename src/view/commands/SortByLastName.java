package view.commands;

import view.ConsoleUI;

public class SortByLastName  extends  Command{
    public SortByLastName(ConsoleUI consoleUI){
        super("Сортировать по фамилии", consoleUI);
    }
    @Override
    public void execute(){
        getConsoleUI().sortByLastName();
    }
}