package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class BirthChildren extends Command {
    
        public BirthChildren(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Рождение ребенка";
    }

    public void execute(){
        consoleUI.birthChildren();
    }    
}
