package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI){
        super(consoleUI);
        description = "I want to finish work";
    }

    public void execute(){
        consoleUI.finish();
    }
}
