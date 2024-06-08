package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class SortByAmountOfChildren extends Command {

    public SortByAmountOfChildren(ConsoleUI consoleUI) {
        super("sort 'em by amount of children", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAmountOfChildren();
    }
}