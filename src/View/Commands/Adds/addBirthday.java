package View.Commands.Adds;

import View.Commands.Command;
import View.ConsoleUi;

public class addBirthday  extends Command {

    public addBirthday(ConsoleUi consoleUi) {
        super("Добавить дату рождения\n", consoleUi);
    }

    @Override
    public void execute() {
        consoleUi.addBirthday();
    }
}
