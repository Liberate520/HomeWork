package view.comands;

import view.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI, "Завершение работы");
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
