package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to see family members list sorted by name";
    }

    public void execute() {
        consoleUI.sortByName();
    }
}
