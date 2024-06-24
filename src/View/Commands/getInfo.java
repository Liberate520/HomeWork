package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class getInfo extends Command{
    public getInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о человеке";
    }


    public void execute() {
        consoleUI.getInfo();
    }
}
