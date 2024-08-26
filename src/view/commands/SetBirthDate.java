package view.commands;

import view.ConsoleUI;

public class SetBirthDate extends Command{

    public SetBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить дату рождения.";
    }

    @Override
    public void execute() {
        consoleUI.setBirthDate();
    }
}
