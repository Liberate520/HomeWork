package View.RelationsMenu;

import View.ConsoleUI;

public class AddChild extends AddRelations{

    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка.";
    }

    @Override
    public void execute(int humanID) {
        consoleUI.addChildMenu(humanID);
    }
}
