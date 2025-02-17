package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddParent extends Command {

    public AddParent(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить родителя/ребенка");
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();

    }
}
