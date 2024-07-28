package group.model.view.comands;

import group.model.view.ConsoleUI;

public class sortByDeathDate extends Commands {

    public sortByDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по возрасту.";
    }

    public void execute(){
        consoleUI.sortByDeathDate();
    }
}
