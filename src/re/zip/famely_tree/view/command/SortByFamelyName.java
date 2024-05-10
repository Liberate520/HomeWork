package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class SortByFamelyName extends Command{

    public SortByFamelyName (ConsoleUI consoleUI) {
        super("Отсортировать членов семьи по фамилии", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().sortByFamelyName();
    }
}