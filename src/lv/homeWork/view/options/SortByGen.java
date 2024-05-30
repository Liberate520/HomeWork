package lv.homeWork.view.options;

import lv.homeWork.view.ConsoleUI;

public class SortByGen extends Option{
    public SortByGen(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort FamilyTree by Generation";
    }

    @Override
    public void act() {
        consoleUI.sortByGen();

    }
}
