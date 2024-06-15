package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class addCreature extends Command{
    public addCreature(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Добавить Существо";
    }

    public void execute(){
        consoleUI.addCreature();
    }

    @Override
    public void execute(Human human) {

    }
}
