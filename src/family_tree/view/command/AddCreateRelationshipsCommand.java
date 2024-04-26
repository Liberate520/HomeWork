package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class AddCreateRelationshipsCommand extends Command {


    public AddCreateRelationshipsCommand(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить связи между людьми");
    }

    @Override
    public void execute() {
        getConsoleUI().addCreateRelationshipsCommand();
    }

}
