package View.Commands.Adds;

import View.Commands.Command;
import View.ConsoleUi;

public class addDeathDate  extends Command {
    public addDeathDate(ConsoleUi consoleUi) {
        super("Добавить дату смерти\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.addDeathDate();
    }
}
