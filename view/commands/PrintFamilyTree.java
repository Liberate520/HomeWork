package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class PrintFamilyTree extends Command {
    
        public PrintFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать семейное дерево";
    }

    public void execute(){
        consoleUI.printFamilyTree();
    }
}
