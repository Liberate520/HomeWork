package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class SortByFirstName extends Command{

    public SortByFirstName (ConsoleUI consoleUI) {
        super("Отсортировать членов семьи по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByFirstName();
    }
}