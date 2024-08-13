package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class SetSpouse extends Command{

    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to set husband-wife relationship in the tree";
    }

    public void execute(){
        consoleUI.setSpouse();
    }

}
