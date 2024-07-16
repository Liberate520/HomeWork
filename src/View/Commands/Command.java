package View.Commands;

import View.ConsoleUI;

public abstract class Command {
    private final String descripton;
    private ConsoleUI consoleUI;

    public Command(String descripton, ConsoleUI consoleUI) {
        this.descripton = descripton;
        this.consoleUI = consoleUI;
    }

    public String getDescripton() {
        return descripton;
    }
    public abstract void execute();

     ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
