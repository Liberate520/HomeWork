package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SearchHumansChild extends Command {
    public SearchHumansChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти детей человека в древе";
    }

    @Override
    public void execute() {
        consoleUI.searhHumansChild();
    }
}
