package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class addChild extends Command{
    public addChild(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить Ребёнка";
    }

    public void execute(){
        consoleUI.addChild();
    }
}
