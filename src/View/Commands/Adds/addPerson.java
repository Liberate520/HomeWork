package View.Commands.Adds;

import View.Commands.Command;
import View.ConsoleUi;

public class addPerson extends Command {

    public addPerson(ConsoleUi consoleUi) {
        super("Добавить человека\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.addPerson();
    }
}
