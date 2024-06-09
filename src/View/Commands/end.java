package View.Commands;

import View.Commands.Command;
import View.ConsoleUi;

public class end extends Command {
    public end(ConsoleUi consoleUi) {
        super("Выйти\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.end();
    }
}

