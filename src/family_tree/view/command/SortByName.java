package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class SortByName extends Command{
    public SortByName(ConsoleUI consoleUI){
        super("���������� �� �����", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().sortByName();
    }
}
