package view.commands;

import view.ConsoleUI;

public class AddParent extends Command{

    public AddParent (ConsoleUI consoleUI) {

        super(consoleUI);
        description = "Добавить родителя";

    }

    public void execute() {
        consoleUI.addParent();
    }

}
