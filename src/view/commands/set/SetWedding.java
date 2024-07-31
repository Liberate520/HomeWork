package view.commands.set;

import view.ConsoleUI;
import view.commands.Command;

public class SetWedding extends Command {
    public SetWedding(ConsoleUI consoleUI) {
        super("Организовать свадьбу", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setWedding();
    }
}
