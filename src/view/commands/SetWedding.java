package view.commands;

import view.ConsoleUI;

public class SetWedding extends Command{
    public SetWedding(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Создать семью";
    }

    @Override
    public void execute() {
        consoleUI.setWedding();
    }
}
