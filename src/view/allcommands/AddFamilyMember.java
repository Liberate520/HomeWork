package view.allcommands;

import view.ConsoleUI;

public class AddFamilyMember extends Command{

    public AddFamilyMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description="Добавить объект в семейное древо";
    }

    @Override
    public void execute() {
        consoleUI.addFamilyMember();
    }
}
