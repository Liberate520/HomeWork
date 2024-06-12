package OOP.SemDZ.homeWork.view.commands;

import OOP.SemDZ.homeWork.view.ConsoleUI;

public class SortByAge extends Command {
  
        public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать дерево по возрасту";
    }

    public void execute(){
        consoleUI.sortByAge();
    }
}
