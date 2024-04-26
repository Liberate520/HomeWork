package view.commands;

import view.ConsoleUI;

public class AddBirthDate extends Command {
    public AddBirthDate(ConsoleUI consoleUI) {
        super("Добавить дату рождения", consoleUI);
    }

    public void execute() {
        getConsoleUI().addBirthDate();
    }
}