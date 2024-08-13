package lv.homeWork.view.options;

import lv.homeWork.view.ConsoleUI;

public class ShowList extends Option{
    public ShowList(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Show me what's in the family tree";
    }

    @Override
    public void act() {
        consoleUI.showList();

    }
}
