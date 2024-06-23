package View.Commands.Searches;

import View.Commands.Command;
import View.ConsoleUi;

public class getPersonOnSurname extends Command {

    public getPersonOnSurname(ConsoleUi consoleUi) {
        super("Поиск человека по фамилии\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.getPersonOnSurname();
    }
}