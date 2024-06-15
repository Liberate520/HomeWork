package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class getSisters extends Command{
    public getSisters(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить информацию о сёстрах существа";
    }

    @Override
    public void execute() {

    }


    public void execute(Human human){
        consoleUI.getSister(human);
    }
}
