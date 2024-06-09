package View.Commands.Searches;

import View.Commands.Command;
import View.ConsoleUi;

public class getFullPerson extends Command {

    public getFullPerson(ConsoleUi consoleUi) {
        super("Поиск человека по индексу\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.getFullPerson();
    }
}
