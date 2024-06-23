package View.Commands.Adds;

import View.Commands.Command;
import View.ConsoleUi;

public class addParent  extends Command {

    public addParent(ConsoleUi consoleUi) {
        super("Добавить родитея\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.addParent();
    }
}
