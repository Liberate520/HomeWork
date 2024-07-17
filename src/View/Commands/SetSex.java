package View.Commands;

import View.ConsoleUI;

public class SetSex extends Command {
    public SetSex(ConsoleUI consoleUI) {
        super("Задать пол", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SetSex();
    }
}
