package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class AddHuman extends Command{

    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to add a new human to the family tree";
    }

    public void execute() {
        consoleUI.addHuman();
    }
}
