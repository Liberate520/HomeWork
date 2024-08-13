package lv.homeWork.view.options;

import lv.homeWork.view.ConsoleUI;

public class SortByAge extends Option {
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Sort FamilyTree by age";
    }

    @Override
    public void act() {
        consoleUI.sortByAge();
    }
}
