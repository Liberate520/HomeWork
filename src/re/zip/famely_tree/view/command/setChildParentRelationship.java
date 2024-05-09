package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class SetChildParentRelationship extends Command {


    public SetChildParentRelationship(ConsoleUI consoleUI) {
        super("Зарегистирровать связь дети-родители", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setChildParentRelationship();
    }
}
