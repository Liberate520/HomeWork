package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class setSpouse extends Command{

    public setSpouse(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Брак с человеком";
    }

    public void execute(){
        consoleUI.setSpouse();

    }
}
