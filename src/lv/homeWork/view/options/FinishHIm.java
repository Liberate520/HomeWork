package lv.homeWork.view.options;

import lv.homeWork.view.ConsoleUI;

public class FinishHIm extends Option {
    public FinishHIm(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Stop the Program";
    }

    @Override
    public void act() {
        consoleUI.finishHim();
    }
}
