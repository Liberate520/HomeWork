package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class addMother extends Command{
    public addMother(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить Мать";
    }

    public void execute(){
        consoleUI.addMother();

    }
}
