package seminar2.View.commands.commands;

import seminar2.View.commands.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI) {
        super("завершение работы приложения", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().finish();
    }
}
