package View.Commands;

import View.ConsoleUi;

public abstract class Command {
    protected String discription;
    protected ConsoleUi consoleUi;

    public Command(String discription, ConsoleUi consoleUi) {
        this.discription = discription;
        this.consoleUi = consoleUi;
    }
    public abstract void execute();

    public String getDiscription() {
        return discription;
    }
}
