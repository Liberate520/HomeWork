package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class sortByAge extends Command{
    public sortByAge(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Отсортировать список по возрасту";
    }


    @Override
    public void execute(){
        consoleUI.sortByAge();
    }
}
