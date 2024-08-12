package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class AddEntity extends Command{
    public AddEntity(ConsoleUI consoleUI){
        super("add", "Добавление существа в древо", consoleUI);
    }

    @Override
    public void execute() {
       super.getConsoleUI().addEntity();
    }
}
