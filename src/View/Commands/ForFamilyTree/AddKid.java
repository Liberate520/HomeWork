package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class AddKid extends Command{
    public AddKid(ConsoleUI consoleUI){
        super("add kid", "Добавить ребёнка", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().addKid();
    }
}
