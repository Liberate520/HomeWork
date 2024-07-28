package view.commands.set;

import view.ConsoleUI;
import view.commands.Command;

public class SetFather extends Command {
    public SetFather(ConsoleUI consoleUI) {
        super("Добавить отца", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setFather();
    }
}