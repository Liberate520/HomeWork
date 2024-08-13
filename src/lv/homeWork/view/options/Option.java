package lv.homeWork.view.options;

import lv.homeWork.view.ConsoleUI;

public abstract class Option {
    String description;
    ConsoleUI consoleUI;

    public Option(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }

    public String getDescription(){
        return description;
    }

    public abstract void act();
}
