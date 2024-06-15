package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        consoleUI.finish();
    }

    @Override
    public void execute(Human human) {

    }
}
