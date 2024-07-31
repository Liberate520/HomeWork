package view.commands.add;

import view.ConsoleUI;
import view.commands.Command;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека в семейное древо", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().addHuman();
    }
}
