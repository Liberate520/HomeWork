package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class AddHuman extends Command {

        public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить нового члена семьи";
    }

    public void execute(){
        consoleUI.addHuman();
    }    
}
