package view.comand;

import view.ConsoleUI;

public class GetParentByNum extends Command{
    public GetParentByNum(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать список родителей по номеру в списке";
    }
    public void execute(){
        consoleUI.getParentByNum();
    }
}