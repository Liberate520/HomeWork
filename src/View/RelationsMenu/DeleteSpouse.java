package View.RelationsMenu;

import View.ConsoleUI;

public class DeleteSpouse extends AddRelations{

    public DeleteSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить супруга/супругу.";
    }

    @Override
    public void execute(int humanID) {
        consoleUI.deleteSpouseMenu(humanID);
    }
}
