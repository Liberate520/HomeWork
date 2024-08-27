package View.RelationsMenu;

import View.ConsoleUI;

public class FinishRelationsChoice extends AddRelations{

    public FinishRelationsChoice(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить выбор.";
    }

    @Override
    public void execute(int humanID) {
        consoleUI.finishRelationsChoice();
    }
}