package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class FindEntity extends Command{
    public FindEntity(ConsoleUI consoleUI){
        super("find", "Найти существо по имени и фамилии", consoleUI);
    }

    @Override
    public void execute() {
            super.getConsoleUI().findEntity();
    }
}
