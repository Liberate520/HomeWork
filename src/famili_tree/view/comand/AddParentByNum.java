package view.comand;

import view.ConsoleUI;

public class AddParentByNum extends Command{
    public AddParentByNum(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя по номеру в списке";
    }
    public void execute(){
        consoleUI.addParentByNum();
    }
}
