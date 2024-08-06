package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class SetMother extends Command{

    public SetMother(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to set mother-child relationship between humans";
    }

    public void execute(){
        consoleUI.setMother();
    }
}
