package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class getInfo extends Command{
    public getInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о существе";
    }

    @Override
    public void execute() {

    }


    public void execute(Human human){
        consoleUI.getInfo(human);
    }
}
