package View.RelationsMenu;

import View.ConsoleUI;

public class AddSpouse extends AddRelations{

    public AddSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить супруга/супругу.";
    }

    @Override
    public void execute(int humanID) {
        consoleUI.addSpouseMenu(humanID);
    }
}
