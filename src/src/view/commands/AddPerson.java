package src.view.commands;

import src.view.ConsoleUI;

public class AddPerson extends Command {
    
    public AddPerson(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    @Override
    public void execute() {
        consoleUI.addPerson();
    }
}
