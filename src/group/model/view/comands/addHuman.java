package group.model.view.comands;

import group.model.view.ConsoleUI;

public class addHuman extends Commands {

    public addHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родственника";
    }


    @Override
    public void execute() {
        consoleUI.addHuman();
    }
}
