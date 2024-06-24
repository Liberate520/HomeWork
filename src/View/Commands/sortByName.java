package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class sortByName extends Command{
    public sortByName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Отсортировать список по имнеи";
    }


    @Override
    public void execute(){
        consoleUI.sortByName();
    }
}
