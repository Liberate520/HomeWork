package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class sortByChildrenAmount extends Command{
    public sortByChildrenAmount(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Отсортировать список по количеству детей";
    }


    @Override
    public void execute(){
        consoleUI.sortByCountChildren();
    }
}
