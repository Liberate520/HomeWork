package view.comand;

import view.ConsoleUI;

public class AddParentById extends Command{
    public AddParentById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителя по ID";
    }
    public void execute(){
        consoleUI.addParentById();
    }
}