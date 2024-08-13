package lv.homeWork.view.options;

import lv.homeWork.view.ConsoleUI;

public class AddHuman extends Option {
    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add a new family tree member ";
    }

    @Override
    public void act() {
        consoleUI.addHuman();


    }
}
