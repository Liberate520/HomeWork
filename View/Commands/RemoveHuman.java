package homeWork.View.Commands;

import homeWork.View.ConsoleUI;

public class RemoveHuman extends Command{

    public RemoveHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить человека";
    }

    public void execute(){
        consoleUI.removeHuman();
    }
}
