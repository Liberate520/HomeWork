package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class SetFather extends Command{

    public SetFather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to set father-child relationship between humans";
    }

    public void execute(){
        consoleUI.setFather();
    }
    
}
