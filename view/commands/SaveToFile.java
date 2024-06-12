package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class SaveToFile extends Command {
  
        public SaveToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Записать данные в файл";
    }

    public void execute(){
        consoleUI.saveToFile();
    }
}
