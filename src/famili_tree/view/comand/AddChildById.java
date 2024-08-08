package view.comand;

import view.ConsoleUI;

public class AddChildById extends Command{
    public AddChildById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка по ID";
    }
    public void execute(){
        consoleUI.addChildById();
    }
}
