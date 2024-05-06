package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class AddChild extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super("Добавить ребенка", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChild();
    }
}
