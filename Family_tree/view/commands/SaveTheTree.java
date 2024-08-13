package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class SaveTheTree extends Command{

    public SaveTheTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to save changes made to the family tree";
    }

    public void execute(){
        consoleUI.saveTheTree();
    }
    
}
