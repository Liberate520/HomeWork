package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddMarriage extends Command {
    public AddMarriage(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить брак");
    }

    @Override
    public void execute() {
        getConsoleUI().addMarriage();

    }
}
