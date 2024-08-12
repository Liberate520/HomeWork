package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddSpouse extends Command {
    public AddSpouse(ConsoleUI consoleUI) {
        super("Установить супружескую взаимосвязь", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addSpouse();
    }
}
