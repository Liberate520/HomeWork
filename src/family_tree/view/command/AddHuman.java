package family_tree.view.command;

import family_tree.view.ConsoleUI;

public class AddHuman extends Command {


    public AddHuman(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить человека");
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }

}
