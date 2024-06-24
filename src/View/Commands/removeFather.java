package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class removeFather extends Command{
    public removeFather(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Убрать Отца";
    }

    public void execute(){
        consoleUI.removeFather();

    }
}
