package familytree.view.commands;

import familytree.view.ConsoleUI;

public class AddFamilyMember extends Command {

    public AddFamilyMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека в древо";
    }

    public void execute() {
        consoleUI.addFamilyMember();
    }
}
