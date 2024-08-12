package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class DeleteSpouse extends Command {
    public DeleteSpouse(ConsoleUI consoleUI) {
        super("Удалить супружескую взаимосвязь", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().deleteSpouse();
    }
}