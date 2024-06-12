package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class LoadOfFile extends Command {
 
        public LoadOfFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить данные из файла";
    }

    public void execute(){
        consoleUI.loadOfFile();
    } 
}
