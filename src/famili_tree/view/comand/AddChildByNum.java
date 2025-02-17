package view.comand;

import view.ConsoleUI;

public class AddChildByNum extends Command{
    public AddChildByNum(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка по номеру в списке";
    }
    public void execute(){
        consoleUI.addChildByNum();
    }
}