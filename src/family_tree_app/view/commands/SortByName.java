package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class SortByName extends Command {

     public SortByName(ConsoleUI consoleUI) {
        super("sort 'em by name", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }

}
