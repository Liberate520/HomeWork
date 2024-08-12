package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetSpouse extends Command{
    public SetSpouse(ConsoleUI consoleUI){
        super("set spouse", "Изменить супруга у существа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setEntitySpouse();
    }
}
