package View.RelationsMenu;

import View.ConsoleUI;

public class AddParent extends AddRelations{

    public AddParent(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить родителя (мать, отца).";
    }

    @Override
    public void execute(int humanID) {
        consoleUI.addParentMenu(humanID);
    }
}