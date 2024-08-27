package View.Commands;

import View.ConsoleUI;

public class AddRelative extends Command{

    public AddRelative(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Изменить родственные связи";
    }

    public void execute() {
        consoleUI.addRelations();
    }
}
