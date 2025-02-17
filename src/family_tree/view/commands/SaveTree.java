package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}
