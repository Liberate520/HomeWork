package View.Commands.Adds;

import View.Commands.Command;
import View.ConsoleUi;

public class addChield  extends Command {

    public addChield(ConsoleUi consoleUi) {
        super("Добавить ребенка\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.addChield();
    }
}
