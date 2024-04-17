package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class SortByName extends  Command{
    public SortByName(ConsoleUI consoleUI) {
        super("Sort by name", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().sortByName();
    }
}
