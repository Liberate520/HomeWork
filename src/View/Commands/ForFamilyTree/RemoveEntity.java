package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class RemoveEntity extends Command{
    public RemoveEntity(ConsoleUI consoleUI){
        super("del", "Удаление существа из древа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().removeEntity();
    }
}
