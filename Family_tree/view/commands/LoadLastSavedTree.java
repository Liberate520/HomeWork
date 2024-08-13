package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class LoadLastSavedTree extends Command{

    public LoadLastSavedTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to see last saved family tree";
    }

    public void execute() {
        consoleUI.loadLastSavedTree();
    }


}
