package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class SortByName extends Command {
    
        public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать дерево по имени";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}
