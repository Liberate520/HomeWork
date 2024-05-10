package re.zip.famely_tree.view.command;

import re.zip.famely_tree.view.ConsoleUI;

public class SetSiblingsRelationship extends Command {


    public SetSiblingsRelationship(ConsoleUI consoleUI) {
    super("Зарегистирровать связь братьев(сесетр)", consoleUI);
}

@Override
public void execute() {
    getConsoleUI().setSiblingsRelationship();
}
}