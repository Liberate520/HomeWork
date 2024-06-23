package View.Commands.Searches;

import View.Commands.Command;
import View.ConsoleUi;

public class getAllIndices extends Command {

    public getAllIndices(ConsoleUi consoleUi) {
        super("Получить все индексы\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.getAllIndices();
    }
}