package family_tree_app.view.commands;

import family_tree_app.view.ConsoleUI;

public class SortByAge extends Command {
    public SortByAge(ConsoleUI consoleUI) {
        super("sort 'em by age", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByAge();
    }
}