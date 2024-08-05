package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class FindByName extends Command {
    public FindByName(ConsoleUI consoleUI) {
        super("Найти человека по имени.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().findByName();
    }
}
