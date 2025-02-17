package view.comand;

import view.ConsoleUI;

public class AddSuprugByNum extends Command{
    public AddSuprugByNum(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить супруга по номеру в списке";
    }
    public void execute(){
        consoleUI.addSuprugByNum();
    }
}