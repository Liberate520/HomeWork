package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class getBrothers extends Command{
    public getBrothers(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о братьях существа";
    }

    @Override
    public void execute() {

    }


    public void execute(Human human){
        consoleUI.getSister(human);
    }
}
