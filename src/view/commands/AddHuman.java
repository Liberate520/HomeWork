package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Add Human";
    }

    public void execute(){
        consoleUI.addHuman();
    }
}