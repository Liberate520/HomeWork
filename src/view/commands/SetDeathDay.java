package view.commands;

import view.ConsoleUi;

public class SetDeathDay extends Command{

    public SetDeathDay(ConsoleUi consoleUi) {
        super("Добавить дату смерти человека", consoleUi);
    }

    @Override
    public void execute() {
        getConsoleUi().setDeath();

    }
}
