package GB_Homework.View.Commands;


import GB_Homework.View.ConsoleUI;

public class Finish extends Command{

    public Finish(ConsoleUI consoleUI) {
        super("Завершение работы", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}
