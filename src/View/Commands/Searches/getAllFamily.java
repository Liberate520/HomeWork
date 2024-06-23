package View.Commands.Searches;

import View.Commands.Command;
import View.ConsoleUi;

public class getAllFamily extends Command {

    public getAllFamily(ConsoleUi consoleUi) {
        super("Получить все записи\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.getAllFamily();
    }
}