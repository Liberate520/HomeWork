package View.Commands;

import View.ConsoleUI;

public class AddHumanCommand extends Command{

    public AddHumanCommand(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}
