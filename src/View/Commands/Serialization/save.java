package View.Commands.Serialization;

import View.Commands.Command;
import View.ConsoleUi;

public class save extends Command {
    public save(ConsoleUi consoleUi) {
        super("Сортировка\n", consoleUi);
    }
    @Override
    public void execute() {
        consoleUi.save();
    }
}
