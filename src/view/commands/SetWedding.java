package view.commands;

import view.ConsoleUI;

public class SetWedding extends Command{

    public SetWedding(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Поженить 2 людей";
    }
    @Override
    public void execute() {
        consoleUI.setWedding();
    }
}