package view.commands.set;

import view.ConsoleUI;
import view.commands.Command;

public class SetDivorce extends Command {
    public SetDivorce(ConsoleUI consoleUI) {
        super("Оформить развод", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setDivorce();
    }
}