package View.Commands;

import Model.Human.Human;
import View.ConsoleUI;

public class printFamilyTree extends Command{
    public printFamilyTree(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Получить семейное древо";
    }

    @Override
    public void execute() {
        consoleUI.printFamilyTree();
    }

    @Override
    public void execute(Human human) {

    }
}
