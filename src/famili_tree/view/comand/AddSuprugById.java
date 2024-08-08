package view.comand;

import view.ConsoleUI;

public class AddSuprugById extends Command{
    public AddSuprugById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить супруга по ID";
    }
    public void execute(){
        consoleUI.addSuprugById();
    }
}
