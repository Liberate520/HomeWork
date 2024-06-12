package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class Wedding extends Command {
    
        public Wedding(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Свадьба";
    }

    public void execute(){
        consoleUI.wedding();
    }
}
