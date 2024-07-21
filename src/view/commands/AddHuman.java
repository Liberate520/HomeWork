package view.commands;

import view.ConsoleUI;

public class AddHuman extends Commands {

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить родственника в семейное древо.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}
