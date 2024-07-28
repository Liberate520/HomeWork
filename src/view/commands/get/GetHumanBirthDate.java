package view.commands.get;

import view.ConsoleUI;
import view.commands.Command;

public class GetHumanBirthDate extends Command {
    public GetHumanBirthDate(ConsoleUI consoleUI) {
        super("Показать дату рождения человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanBirthDate();
    }
}
