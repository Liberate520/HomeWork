package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class getName extends Command{
    public getName(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о отце существа";
    }

    @Override
    public void execute() {

    }


    public void execute(Human human){
        consoleUI.getInfo(human);
    }
}
