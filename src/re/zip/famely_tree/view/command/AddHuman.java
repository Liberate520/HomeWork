package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class AddHuman extends Command {

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить члена семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHumanToFamelyTree();
    }
}