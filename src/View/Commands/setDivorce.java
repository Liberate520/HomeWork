package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class setDivorce extends Command{

    public setDivorce(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Развод с членом брака";
    }

    public void execute(){
        consoleUI.setDivorce();

    }

}
