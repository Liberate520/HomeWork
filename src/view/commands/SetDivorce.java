package view.commands;

import view.ConsoleUI;

public class SetDivorce extends Command{

    public SetDivorce(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Развести 2 людей";
    }
    @Override
    public void execute() {
        consoleUI.setDivorce();
    }
}