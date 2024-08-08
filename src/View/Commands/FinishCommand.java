package View.Commands;

import View.ConsoleUI;

public class FinishCommand extends Command{

    public FinishCommand(ConsoleUI consoleUI) {
        super("Завершение работы", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
