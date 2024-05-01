package view.commands;

import view.ConsoleUI;

public class LoadTree extends Command {
    public LoadTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Load Family Tree";
    }

    public void execute(){
        consoleUI.loadTree();
    }
}