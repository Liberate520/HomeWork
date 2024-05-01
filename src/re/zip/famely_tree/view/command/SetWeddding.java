package re.zip.famely_tree.view.command;

import re.zip.famely_tree.model.human.Human;
import re.zip.famely_tree.view.ConsoleUI;

public class SetWeddding extends Command {

    public SetWeddding(ConsoleUI consoleUI) {
        super("Зарегистирровать брак", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SetWeddding();
    }
}