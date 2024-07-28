package group.model.view.comands;

import group.model.view.ConsoleUI;

public class sortByName extends Commands {

    public sortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по имени";
    }

    public void execute(){
        consoleUI.sortByName();
    }

}
