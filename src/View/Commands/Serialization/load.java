package View.Commands.Serialization;

import View.Commands.Command;
import View.ConsoleUi;

public class load extends Command {
    public load(ConsoleUi consoleUi) {
        super("Загрузка\n", consoleUi);
    }
    @Override
    public void execute() {
        consoleUi.load();
    }

}
