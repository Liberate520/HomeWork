package src.view.commands;

import src.view.ConsoleUI;

public class Kinship extends Command {

    

    public Kinship(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "установить родсвенную связь(родитель , ребенок)";
    }

    @Override
    public void execute() {
        consoleUI.kinship();
    }
}

   
