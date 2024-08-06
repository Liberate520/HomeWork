package Family_tree.view.commands;

import Family_tree.view.ConsoleUI;

public class SortByAge extends Command{
    public SortByAge(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "I want to see family members list sorted by age";
    }

    public void execute() {
        consoleUI.sortByAge();
    }
}
