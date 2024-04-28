package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetParent extends Command {
    public SetParent(ConsoleUI consoleUI) {
        super("Установить отца", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setParent();

    }
}
