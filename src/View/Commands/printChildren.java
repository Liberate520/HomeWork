package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class printChildren extends Command {
    public printChildren(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Выписать детей существа";
    }

    @Override
    public void execute() {

    }

    public void execute(Human human){
        consoleUI.printChildren(human);
    }
}
