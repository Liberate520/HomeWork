package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class addCreature extends Command{
    public addCreature(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить Человека";
    }

    @Override
    public void execute(){
        consoleUI.addCreature();
    }
}
