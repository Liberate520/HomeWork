package family_tree.view.consoleUI.commandsConsole;

import family_tree.view.consoleUI.ConsoleUI;

public class SortByName extends Command {

    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        name = "Сортировать записи по имени";
    }

    @Override
    public void execute() {
        consoleUI.sortByName();
    }
}
