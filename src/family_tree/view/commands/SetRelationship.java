package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class SetRelationship extends Command {
    public SetRelationship(ConsoleUI consoleUI) {
        super("Установить взаимосвязь ребёнок-родитель", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setRelationship();
    }
}