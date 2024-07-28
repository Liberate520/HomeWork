package group.model.view.comands;

import group.model.view.ConsoleUI;
import group.model.view.comands.Commands;

public class addWedding extends Commands {
    public addWedding(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отец/Мать.";
    }

    @Override
    public void execute() {
        consoleUI.addWedding();
    }

}
