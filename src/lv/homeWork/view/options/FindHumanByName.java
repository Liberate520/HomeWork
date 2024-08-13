package lv.homeWork.view.options;

import lv.homeWork.view.ConsoleUI;

public class FindHumanByName extends Option{

    public FindHumanByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Find Human by his Full Name";
    }

    @Override
    public void act() {
        consoleUI.findHumanByName();

    }
}
