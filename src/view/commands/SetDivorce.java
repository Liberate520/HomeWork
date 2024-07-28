package view.commands;

import view.ConsoleUI;

public class SetDivorce extends Command{
    public SetDivorce(ConsoleUI consoleUI) {
        super("Оформить развод", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setDivorce();
    }
}