package family_tree.view.commands;

import family_tree.view.ConsoleUI;


public class SearchHumanByName extends Command {
    public SearchHumanByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти человека древа по имени";
    }

    @Override
    public void execute() {
        consoleUI.searhHumansByName();
    }
}
