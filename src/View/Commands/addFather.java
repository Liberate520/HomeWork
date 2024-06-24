package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class addFather extends Command{
    public addFather(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить Отца";
    }

    public void execute(){
        consoleUI.addFather();

    }
}
