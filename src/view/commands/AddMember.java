package view.commands;

import view.ConsoleUI;

public class AddMember extends Command {
    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить члена семьи";
    }

    @Override
    public void execute() {
        consoleUI.addMember();
    }
}
