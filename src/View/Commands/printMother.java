package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class printMother extends Command{
    public printMother(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о матери существа";
    }

    @Override
    public void execute() {

    }


    public void execute(Human human){
        consoleUI.printMother(human);
    }
}
