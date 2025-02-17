package family_tree.view.commands;

import family_tree.view.ConsoleUI;

public class AddPerson extends Command{

    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI, "Добавить человека");
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();

    }
}
