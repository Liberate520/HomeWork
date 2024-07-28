package view.commands;

import view.ConsoleUI;

public class GetHumanBirthDate extends Command {
    public GetHumanBirthDate(ConsoleUI consoleUI) {
        super("Показать дату рождения человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getHumanBirthDate();
    }
}
