package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class Finish extends Command {
 
        public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Завершение работы";
    }

    public void execute(){
        consoleUI.finish();
    } 
}
