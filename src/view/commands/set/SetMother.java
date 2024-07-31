package view.commands.set;

import view.ConsoleUI;
import view.commands.Command;

public class SetMother extends Command {
    public SetMother(ConsoleUI consoleUI) {
        super("Добавить маму", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setMother();
    }
}