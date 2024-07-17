package View.Commands;

import View.ConsoleUI;

public class SetSpouse extends Command {
    public SetSpouse(ConsoleUI consoleUI) {
        super("Создать брачные узы", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SetSpouse();
    }
}
