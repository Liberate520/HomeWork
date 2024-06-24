package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class removeChild extends Command{

    public removeChild(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Убрать Ребёнка";
    }

    public void execute(){
        consoleUI.removeChild();

    }
}
