package view.comand;

import view.ConsoleUI;



public class Save extends Command{
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить семейное дерево";
    }
    public void execute(){
        consoleUI.save();
    }
}
