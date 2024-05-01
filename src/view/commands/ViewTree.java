package view.commands;

import view.ConsoleUI;

public class ViewTree extends Command {
    public ViewTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "View Family Tree";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}