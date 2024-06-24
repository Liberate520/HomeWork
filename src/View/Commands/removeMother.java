package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class removeMother extends Command{

    public removeMother(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Убрать Мать";
    }

    public void execute(){
        consoleUI.removeMother();

    }
}
