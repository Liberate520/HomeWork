package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SortByBirthday  extends Command{
    public SortByBirthday(ConsoleUI consoleUI) {
        super("Отсортировать по возросту", consoleUI);
    }

    @Override
    public void execute(){
        consoleUI.sortByBirthday();
    }

}